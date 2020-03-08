package com.pool;

import java.util.*;

public class SimplePoolObject {
	private int value;
	private static Random random = new Random();

	SimplePoolObject() {
		final int base = 100;
		value = base + random.nextInt(9 * base);
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return super.toString() + ", value = " + value;
	}
}
