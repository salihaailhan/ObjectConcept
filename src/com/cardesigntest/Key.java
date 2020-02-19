package com.cardesigntest;

public class Key {
	private Lock lock;

	Key(Lock lock) {
		this.lock = lock;
	}

	boolean isValidLock(Lock lock) {
		return lock.codeMatches(this.lock);
	}
}
