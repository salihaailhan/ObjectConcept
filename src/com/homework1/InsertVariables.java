package com.homework1;

public class InsertVariables {

	private String wantValue;

	public InsertVariables(String wValue) {
		// TODO Auto-generated constructor stub
		this.wantValue = wValue;
	}

	public void inVariable(String input) {

		Recursive recursive = new Recursive(wantValue, "");

		String[] arrOfString = input.split(",", 4);

		recursive.permute(arrOfString, 0);

	}

	public void inVariable(int[] input) {

		Recursive recursive = new Recursive(wantValue, "");
		
		recursive.permute(input, 0);
		
	}
	
	public void inVariable(double[] input) {

		Recursive recursive = new Recursive(wantValue, "");
		
		recursive.permute(input, 0);
		
	}

}
