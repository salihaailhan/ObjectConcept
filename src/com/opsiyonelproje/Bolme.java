package com.opsiyonelproje;

final public class Bolme extends Islem {
	public char tip() {
		return '/';
	}

	public int oncelik() {
		return ORTA;
	}

	public Double yap(Double a, Double b) {
		return new Double(a.doubleValue() / b.doubleValue());
	}
}
