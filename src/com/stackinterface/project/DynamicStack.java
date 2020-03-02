package com.stackinterface.project;

public class DynamicStack extends Stack {
	DynamicStack(int size) {
		super(size);
	}
	
	@Override
	public void push(Object item) {
		if(count == capacity()-1) {
			enlargeStack();
		}
		items[count] = item;
		count++;
	}
	
	@Override
	public Object pop() {
		if(count > 0) {
			count--;
			Object item = items[count];
			items[count] = null; // so that garbage collector can collect that item
			return item;
		} else {
			return null;
		}
	}
	
	private void enlargeStack() {
		// create a new array with twice size
		Object newItems[] = new Object[capacity() * 2];
		
		// copy current elements in stack array to this new array
		for (int i=0; i<capacity(); i++) {
			newItems[i] = items[i];
		}
		
		// assign reference of new array to stack array
		items = newItems;
	}
}
