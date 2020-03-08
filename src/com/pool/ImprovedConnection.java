package com.pool;

public class ImprovedConnection {
	ImprovedConnection(String connectionString) {		
		System.out.println("Connection object is created using " + connectionString);	
	}
	
	@Override
	public String toString() {
		return super.toString() + " is a connection object "; 
	}
	
	public void close() {
		System.out.println("Connection is closed for" + super.toString());
	}
}
