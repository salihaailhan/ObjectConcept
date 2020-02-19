package com.cardesigntest;

public class Door {
	private Lock lock;
	private boolean locked = true;

	Door(Lock lock) {
		this.lock = lock;
	}

	boolean isLocked() {
		return locked;
	}

	boolean lock(Key key) {
		if (key.isValidLock(lock)) {
			locked = true;
			return true;
		}
		return false;
	}

	boolean unlock(Key key) {
		if (key.isValidLock(lock)) {
			locked = false;
			return true;
		}
		return false;
	}
}
