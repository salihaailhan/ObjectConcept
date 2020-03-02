package com.optionalproject;

public class Divition extends Operation {
	public char type() {
		return '/';
	}

	public int priority() {
		return MIDDLE;
	}

	public Double doOperation(Double a, Double b) {
		return new Double(a.doubleValue() / b.doubleValue());
	}
}
