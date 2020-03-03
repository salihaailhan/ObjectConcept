package com.polymorphism;

public class Toyota extends Car {

	final double maximumLimit = 200;

	@Override
	void pushAccelerate(double pressure) {
		speed += 2.5 * pressure;
		if (speed > maximumLimit) {
			speed = maximumLimit;
		}
	}

	@Override
	void pushBreake(double pressure) {

	}

	@Override
	public String toString() {
		return "Japanese Toyota";
	}

}
