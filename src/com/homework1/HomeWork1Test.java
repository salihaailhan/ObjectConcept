package com.homework1;

public class HomeWork1Test {

	public static void main(String[] args) {
		HomeWork1Test homeWork1Test = new HomeWork1Test();
		homeWork1Test.test();


	}
	
	void test() {

		InsertVariables insertVariables = new InsertVariables("N,A,A,R", "NAR");
		
		try {
			
			insertVariables.inVariable();
			

		} catch (Exception e) {
			System.out.println("!Note : Use comma between variables");
		}		
	}

}
