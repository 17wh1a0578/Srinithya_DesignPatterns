package epam.DesignPatterns;

class SingletonEagar {
	private static SingletonEagar inst = new SingletonEagar(); 
	private SingletonEagar(){}
	  
	public static SingletonEagar getInstance() {
	  return inst;
	}
}

class singleton {
	private static Singleton instance; 
	private singleton(){}  
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new singleton();
		}
	    
	    return instance;
	}
}

class SingletonSynchronized {
	private static SingletonSynchronized instance; 
	  
	private SingletonSynchronized(){}
	  
	public static synchronized SingletonSynchronized getInstance() {
		if(instance == null) {
			instance = new SingletonSynchronized();
	    }
	    return instance;
	}
}

class SingletonSync {
	private static SingletonSync exInst; 
	  
	private SingletonSync(){}
	  
	public static SingletonSync getInstance() {
		if(exInst == null) {
			synchronized (SingletonSync.class) {
				if(exInst == null) {
					exInst = new SingletonSync();
				}
			}
	    }
	    return exInst;
	}
}

public class Singleton {

	public static void main(String[] args) {
		SingletonSync exInst1 = SingletonSync.getInstance();
	    
	    System.out.println(exInst1);
	    
	    SingletonSync exInst2 = SingletonSync.getInstance();
	    
	    System.out.println(exInst2);
	}
}
