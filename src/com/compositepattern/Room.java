package com.compositepattern;

public class Room implements IStructure {
	private String name;
	
	public Room(String name) {
		this.name = name;
	}
	
	public void enter() {
		System.out.println("You have entered the " + this.name);
		
	}

	public void exit() {
		System.out.println("You have left the " + this.name);
		
	}

	public void location() {
		System.out.println("You are currently in the " + this.name);
	}

	public String getName() {
		
		return this.name;
	}
}
