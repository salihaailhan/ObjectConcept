package com.polymorphism;

public class Ferrari extends Car {
	final double maximumLimit = 250;
	
	@Override
	void pushAccelerate(double pressure) {
		speed += 0.5 * pressure;
		if(speed > maximumLimit) {
			speed = maximumLimit;
		}
	}
	
	@Override
	void pushBreake(double pressure) {
		
	}
	
	@Override
	public String toString() {
		return "Italian Ferrari";
	}
}
