package com.homework1;

public class HomeWork1Test {

	public static void main(String[] args) {
		HomeWork1Test homeWork1Test = new HomeWork1Test();
		homeWork1Test.test();


	}
	
	void test() {
		InsertVariables insertVariables = new InsertVariables();
		
		try {
			
			String inString = "12,11,6,7"; // input values
			String desString = "45"; // Desired output values
			
			System.out.println(insertVariables.inVariable(inString, desString));

				
		} catch (Exception e) {
			System.out.println("!Note : Use comma between variables");
		}		
	}

}
