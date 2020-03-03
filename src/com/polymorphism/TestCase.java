package com.polymorphism;

import java.util.*;

public class TestCase {

	public static void main(String[] args) {
		
		staticPolymorphismTest();
		dynamicPolymorphismTest();

	}
	
	static void staticPolymorphismTest() {
		StaticPolymorphism sp = new StaticPolymorphism();
		
		System.out.println(sp.oper(2, 3));
		System.out.println(sp.oper(2.0, 3.0));
		System.out.println(sp.oper(2, 3.0));
		System.out.println(sp.oper(true, false));
		System.out.println(sp.oper("gurkay", "basyigit"));
	}
	
	static void dynamicPolymorphismTest() {
		List<Car> myCarCollection = new ArrayList<Car>();
		myCarCollection.add(new Ferrari());
		myCarCollection.add(new Tofas());
		myCarCollection.add(new Toyota());
		
		int n = 10;
		for (int i = 0; i < n; i++) {
			double pressure = 10;
			
			for (Car car : myCarCollection) {
				car.pushAccelerate(pressure);
				System.out.println("Speed of " + car + " is " + car.getSpeed());
			}
			
			System.out.println();
		}
	}
	
	/*
	 * public abstract class Car {
	 * 
	 * protected double speed = 0;
	 * 
	 * abstract void pushAccelerate(double pressure);
	 * 
	 * abstract void pushBreake(double pressure);
	 * 
	 * public double getSpeed() { return speed; } }
	 */
	
	/*
	 * public class Ferrari extends Car { final double maximumLimit = 250;
	 * 
	 * @Override void pushAccelerate(double pressure) { speed += 0.5 * pressure;
	 * if(speed > maximumLimit) { speed = maximumLimit; } }
	 * 
	 * @Override void pushBreake(double pressure) {
	 * 
	 * }
	 * 
	 * @Override public String toString() { return "Italian Ferrari"; } }
	 */
	
	/*
	 * public class StaticPolymorphism { int oper(int prm1, int prm2) { return prm1
	 * + prm2; }
	 * 
	 * double oper(double prm1, double prm2) { return prm1 + prm2; }
	 * 
	 * boolean oper(boolean prm1, boolean prm2) { return prm1 | prm2; }
	 * 
	 * String oper(Object prm1, Object prm2) { return prm1.toString() + " " +
	 * prm2.toString(); } }
	 */

}
