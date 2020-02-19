package com.cardesigntest;

import java.util.Random;

public class Lock {
	private static int lockCounter = 0;
	private long code;

	Lock() {
		lockCounter++;
		Random rnd = new Random();

		final int base = 1000000;
		code = lockCounter * base + rnd.nextInt(base);
	}

	boolean codeMatches(Lock lock) {
		return (code == lock.code);
	}
}
