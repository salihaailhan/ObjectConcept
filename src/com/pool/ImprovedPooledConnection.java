package com.pool;

public class ImprovedPooledConnection extends ImprovedConnection{
	private final ImprovedConnectionPoolManager connectionPool;
	
	ImprovedPooledConnection(String connectionString, ImprovedConnectionPoolManager connectionPool) {
		super(connectionString);
		
		this.connectionPool = connectionPool;
	}
	
	@Override
	public void close() {
		connectionPool.returnObjectToPool(this);
	}
	
	public void closeConnection() {
		super.close();
	}
}
