package com.optionalproject;

final public class Subtraction extends Operation{
	public char type() {
		return '-';
	}

	public int priority() {
		return LOW;
	}

	public Double doOperation(Double a, Double b) {
		return new Double(a.doubleValue() - b.doubleValue());
	}
}
