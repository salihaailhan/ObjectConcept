package com.stackinterface.project;

public class FixedStack extends Stack {
	FixedStack(int size) {
		super(size);
	}
	
	@Override
	public void push(Object item) {
		if(count < capacity() - 1) {
			items[count] = item;
			count++;
		}
	}
	
	@Override
	public Object pop() {
		if(count > 0) {
			count--;
			Object item = items[count];
			items[count] = null; // so that garbage collector can collect taht item
			return item;
		} else {
			return null;
		}
	}
}