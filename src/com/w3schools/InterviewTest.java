package com.w3schools;

class Adder {
	static int add(int x, int y) {
		return x + y;
	}
	
	static int add(int x, int y, int z) {
		return x + y + z;
	}

	static double add(double x, double y) {
		return x + y;
	}
	
	void parentFunction() {
		System.out.println("Parent fonction");
	}
}

class ImpAdder extends Adder {
	
	@Override
	void parentFunction() {
		System.out.println("Child function");
	}
	
}

public class InterviewTest {

	public static void main(String[] args) {

		Adder adder = new Adder();

		System.out.println("conclution int : " + adder.add(5, 2));
		System.out.println("conclution double : " + adder.add(5.4, 2.2));
		System.out.println("conclution : " + Adder.add(1.2, 2.2));
		adder.parentFunction();
		
		ImpAdder impAdder = new ImpAdder();
		impAdder.parentFunction();
	}

}
