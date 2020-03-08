package com.pool;

import java.util.*;

public class SimpleObjectPoolManager {
	final static int initialPoolSize = 10;

	private Stack<SimplePoolObject> available = new Stack<SimplePoolObject>();
	private List<SimplePoolObject> inUse = new ArrayList<SimplePoolObject>();

	SimpleObjectPoolManager() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < initialPoolSize; i++) {
			available.push(new SimplePoolObject());
		}
	}

	public SimplePoolObject getObjectFromPool() {
		if (available.size() > 0) {
			SimplePoolObject simplePoolObject = available.pop();
			inUse.add(simplePoolObject);
			return simplePoolObject;
		} else {
			return null;
		}
	}

	public void returnObjectToPool(SimplePoolObject simplePoolObject) {
		inUse.remove(simplePoolObject);
		available.push(simplePoolObject);
	}
}
