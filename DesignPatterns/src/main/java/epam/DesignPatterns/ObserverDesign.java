package epam.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Pattern {
  void var(Observer obj);
  void unvar(Observer obj);
  void x();
}

class DeliveryData implements Pattern {

  private List<Observer> observers;
  private String location;
  
  public DeliveryData() {
    this.observers = new ArrayList<Observer>();
  }
  
  public void var(Observer obj) {
    observers.add(obj);
  }

  public void unvar(Observer obj) {
      observers.remove(obj);
  }

  public void x() {
    for(Observer obj : observers) {
      obj.update(location);
    }
  }

  public void locationChanged() {
    this.location = getLocation();
    notifyObservers();
  }
  
  public String getLocation() {
    return "YPlace";
  }
}


interface y {
  public void update(String location);
}


class Seller implements y {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at Seller - Current Location: " + location);
  }
}

class User implements y {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at User - Current Location: " + location);
  }
}

class DeliveryWarehouseCenter implements y {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at Warehouse - Current Location: " + location);
  }
}

public class ObserverDesign {

  public static void main(String[] args) {
    DeliveryData topic = new DeliveryData();
    
    y obj1 = new Seller();
    y obj2 = new User();
    y obj3 = new DeliveryWarehouseCenter();
    
    topic.var(obj1);
    topic.var(obj2);
    topic.var(obj3);
    
    topic.locationChanged();
    
    topic.unvar(obj3);
    
    System.out.println();
    topic.locationChanged();
    
  }
}
