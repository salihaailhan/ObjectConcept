package com.pool;

import java.util.*;

public class ImprovedConnectionPoolManager {
	final String connectionString;
	final int maximumPoolSize;

	private Stack<ImprovedPooledConnection> available = new Stack<ImprovedPooledConnection>();
	private List<ImprovedPooledConnection> inUse = new ArrayList<ImprovedPooledConnection>();

	ImprovedConnectionPoolManager(String connectionString, int initialPoolSize, int maximumPoolSize) {
		this.connectionString = connectionString;
		this.maximumPoolSize = maximumPoolSize;
		
		initalizePool(initialPoolSize);
	}

	private void initalizePool(int initialPoolSize) {
		for (int i = 0; i < initialPoolSize; i++) {
			available.push(new ImprovedPooledConnection(connectionString, this));
		}
	}

	public synchronized void finalizePool() {
		// closeConnection() calls actual close() method from Connection class:
		// super.close();
		for (ImprovedPooledConnection conn : available) {
			conn.closeConnection();
		}

		for (ImprovedPooledConnection conn : inUse) {
			conn.closeConnection();
		}
	}

	public synchronized ImprovedConnection getObjectFromPool() {
		ImprovedPooledConnection conn = null;

		if (available.size() > 0) {
			conn = available.pop();
		} else {
			if (available.size() < maximumPoolSize) {
				conn = new ImprovedPooledConnection(connectionString, this);
			}
		}
		inUse.add(conn);

		System.out.println(this + " is fetched from connection pool.");

		return conn;
	}

	public int getAvailableConnectionCount() {
		return available.size();
	}

	public int getInUseConnectionCount() {
		return inUse.size();
	}

	public synchronized void returnObjectToPool(ImprovedPooledConnection poolObject) {
		inUse.remove(poolObject);
		available.push(poolObject);
	}

}
