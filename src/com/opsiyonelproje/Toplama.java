package com.opsiyonelproje;

final public class Toplama extends Islem {
	public char tip() {
		return '+';
	}

	public int oncelik() {
		return DUSUK;
	}

	public Double yap(Double a, Double b) {
		return new Double(a.doubleValue() + b.doubleValue());
	}
}
