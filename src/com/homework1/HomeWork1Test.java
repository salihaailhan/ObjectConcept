package com.homework1;

public class HomeWork1Test {

	public static void main(String[] args) {
		HomeWork1Test homeWork1Test = new HomeWork1Test();
		homeWork1Test.test();

	}

	void test() {

		try {
			InsertVariables stringVariables = new InsertVariables("KAR");
			InsertVariables integerVariables = new InsertVariables("65");
			InsertVariables integerVariables2 = new InsertVariables("65");
			InsertVariables doubleVariables = new InsertVariables("46.4");
			
			stringVariables.inVariable("N,A,K,R");
			integerVariables.inVariable(new int[] {12,11,6,8});
			//integerVariables.inVariable(new int[] {12,11,6,8,4,3});
			doubleVariables.inVariable(new double[] {12.0,11.0,6.0,8.0});

		} catch (Exception e) {
			System.out.println("!Note : Use comma between variables");
		}
	}

}
