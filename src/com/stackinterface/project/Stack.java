package com.stackinterface.project;

public abstract class Stack implements InterfaceStack {
	protected Object items[];
	protected int count = 0;
	
	Stack(int size) {
		items = new Object[size];
	}
	
	int size() {
		return count;
	}
	
	int capacity() {
		return items.length;
	}
}