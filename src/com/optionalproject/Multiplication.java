package com.optionalproject;

final public class Multiplication extends Operation{
	public char type() {
		return '*';
	}

	public int priority() {
		return MIDDLE;
	}

	public Double doOperation(Double a, Double b) {
		return new Double(a.doubleValue() * b.doubleValue());
	}
}
