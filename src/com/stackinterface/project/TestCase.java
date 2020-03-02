package com.stackinterface.project;

import java.util.Random;

public class TestCase {

	public static void main(String[] args) {
		// fixed stack test
		Stack fixedStack = new DynamicStack(5);
		InterfaceStack fixedStackInterface = fixedStack;
		fixedStack.push(10);
		fixedStackInterface.push(15L);
		fixedStack.push(20.0);
		fixedStackInterface.push(true);
		fixedStack.push('C');
		fixedStackInterface.push("Java");
		fixedStack.push(new int[] {2, -4, 6});
		fixedStackInterface.push(new Random());
		
		System.out.println("Elements in fixed stack");
		System.out.println("-----------------------");
		while(fixedStack.size() > 0) {
			System.out.println(fixedStack.pop());
		}
		
		System.out.println();

		// dynamic stack test
		System.out.println("Elements in dynamic stack");
		System.out.println("-------------------------");	
		Stack dynamicStack = new DynamicStack(5);
		InterfaceStack dynamicStackInterface = dynamicStack;
		dynamicStackInterface.push(10);
		dynamicStack.push(15L);
		dynamicStackInterface.push(20.0);
		dynamicStack.push(true);
		dynamicStackInterface.push('C');
		dynamicStack.push("Java");
		dynamicStackInterface.push(new int[] {2, -4, 6});
		dynamicStack.push(new Random());

		while (dynamicStack.size() > 0) {
			System.out.println(dynamicStack.pop());
		}
		
	}
	
	/*
	 * public interface InterfaceStack { void push(Object item); Object pop(); }
	 * 
	 * public abstract class Stack implements InterfaceStack { protected Object
	 * items[]; protected int count = 0;
	 * 
	 * Stack(int size) { items = new Object[size]; }
	 * 
	 * int size() { return count; }
	 * 
	 * int capacity() { return items.length; } }
	 * 
	 * public class DynamicStack extends Stack { DynamicStack(int size) {
	 * super(size); }
	 * 
	 * @Override public void push(Object item) { if(count == capacity()-1) {
	 * enlargeStack(); } items[count] = item; count++; }
	 * 
	 * @Override public Object pop() { if(count > 0) { count--; Object item =
	 * items[count]; items[count] = null; // so that garbage collector can collect
	 * that item return item; } else { return null; } }
	 * 
	 * private void enlargeStack() { // create a new array with twice size Object
	 * newItems[] = new Object[capacity() * 2];
	 * 
	 * // copy current elements in stack array to this new array for (int i=0;
	 * i<capacity(); i++) { newItems[i] = items[i]; }
	 * 
	 * // assign reference of new array to stack array items = newItems; } }
	 * 
	 * public class FixedStack extends Stack { FixedStack(int size) { super(size); }
	 * 
	 * @Override public void push(Object item) { if(count < capacity() - 1) {
	 * items[count] = item; count++; } }
	 * 
	 * @Override public Object pop() { if(count > 0) { count--; Object item =
	 * items[count]; items[count] = null; // so that garbage collector can collect
	 * taht item return item; } else { return null; } } }
	 */
}
