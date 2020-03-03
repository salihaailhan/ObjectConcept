package com.polymorphism;

public class Tofas extends Car {
	final double maximumLimit = 150;

	@Override
	void pushAccelerate(double pressure) {
		// TODO Auto-generated method stub
		speed += 1.5 * pressure;
		if (speed > maximumLimit) {
			speed = maximumLimit;
		}

	}

	@Override
	void pushBreake(double pressure) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Turkish Tofas";
	}
}
