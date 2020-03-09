package epam.DesignPatterns;

class Patternvehicle {
 
  private String engine;
  private int wheel;
  
  private int airbags;
  
  public String getEngine() {
    return this.engine;
  }
  
  public int getWheel() {
    return this.wheel;
  }
  
  public int getAirbags() {
    return this.airbags;
  }
  
  private Patternvehicle(Vehicle builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  
  public static class Vehicle {
    private String engine;
    private int wheel;
    
    private int airbags;
    
    public Vehicle(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    public Vehicle setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }
    
    public Patternvehicle build() {
      return new Vehicle2(this);
    }
  }
}

public class BuilderDesign {
  
  public static void main(String[] args) {
    Patternvehicle car = new Patternvehicle.Vehicle("1500cc", 4).setAirbags(4).build();
  Patternvehicle bike = new Patternvehicle.Vehicle("250cc", 2).build();
    
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
