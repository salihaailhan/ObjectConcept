package com.polymorphism;

public abstract class Car {
	
	protected double speed = 0;
	
	abstract void pushAccelerate(double pressure);
	
	abstract void pushBreake(double pressure);
	
	public double getSpeed() {
		return speed;
	}
}