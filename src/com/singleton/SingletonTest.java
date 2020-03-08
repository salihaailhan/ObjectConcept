package com.singleton;

public class SingletonTest {
	public static void main (String[] args) {
		try {
			System.out.println(SingletonClass.getInfo());
			System.out.println(" - System.out.println(SingletonClass.getInfo())");
			System.out.println("===============================================");
			
			SingletonClass singletonClass1 = SingletonClass.getInstance();
			System.out.println(" - SingletonClass singletonClass1 = SingletonClass.getInstance()");
			System.out.println("===============================================================");
			
			singletonClass1.singletonMethod();
			System.out.println("***********");
			
			SingletonClass singletonClass2 = SingletonClass.getInstance();
			System.out.println(" - SingletonClass singletonClass2 = SingletonClass.getInstance()");
			System.out.println("================================================================");
			
			System.out.println(singletonClass1);
			System.out.println(" - System.out.println(singletonClass1)");
			System.out.println("======================================");
			
			singletonClass1.singletonMethod();
			System.out.println("***********");
			
			System.out.println(singletonClass2);
			System.out.println(" - System.out.println(singletonClass2)");
			System.out.println("======================================");
			
			singletonClass2.singletonMethod();
			System.out.println("***********");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}

final class SingletonClass {
	static private SingletonClass instance = null;
	
	private SingletonClass() {
		System.out.println("SingletonClass is constructed.");
	}
	
	static public synchronized SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
	
	static String getInfo() {
		return "This class will be singleton!";
	}
	
	public void singletonMethod() {
		System.out.println("This is a method call from an singleton instance " + this);
	}
}
