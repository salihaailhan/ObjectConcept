package com.polymorphism;

public class StaticPolymorphism {
	int oper(int prm1, int prm2) {
		return prm1 + prm2;
	}

	double oper(double prm1, double prm2) {
		return prm1 + prm2;
	}

	boolean oper(boolean prm1, boolean prm2) {
		return prm1 | prm2;
	}

	String oper(Object prm1, Object prm2) {
		return prm1.toString() + " " + prm2.toString();
	}
}
