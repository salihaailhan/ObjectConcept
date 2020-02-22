package com.homework1;

public class Recursive extends GetSetMethods {

	int countValue = 1;

	public Recursive(String wValue, String cValue) {
		// TODO Auto-generated constructor stub
		super(wValue, cValue);
		

	}

	CalculateValues calculateValues = new CalculateValues();
	Combination combination = new Combination(getWantValue(), getConString());

	/*******************************************************************************************
	 * 
	 * DOUBLE PERMUTATION
	 * 
	 * How to use :
	 * Double[] arr = {1.0, 2.5, 3.7, 4.5}; permute(arr, 0);
	 * 
	 *******************************************************************************************/
	public void permute(double[] arr, int i) {
		
		if (i == arr.length) {
			
			permuteString(getOperators(), 0, getOperators().length() - 1, arr);
			
			return;
		}

		for (int j = i; j < arr.length; j++) {
			
			swap(arr, i, j);
			permute(arr, i + 1); // recurse call
			swap(arr, i, j); // backtracking
		}
	}

	public void swap(double[] arr, int i, int j) {
		double tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public void permuteString(String str, int l, int r, double[] arr) {
		

		if (l == r) {

			// if values are integer implement double
			String[] splitString = str.split("");
			
			combination.printCombination(arr, arr.length, 4, splitString);
			

		} else {
			for (int i = l; i <= r; i++) {
				str = swapString(str, l, i);
				permuteString(str, l + 1, r, arr);
				str = swapString(str, l, i);
			}

		}

	}
	
	public void displayScope() {
		System.out.println(getConString());
	}
	/*****************************************************************************************/
	
	/*****************************************************************************************
	 * 
	 * INTEGER PERMUTATION
	 * 
	 * How to use :
	 * int[] arr = {1, 2, 3, 4}; permute(arr, 0);
	 * 
	 *****************************************************************************************/
	public void permute(int[] arr, int i) {

		if (i == arr.length) {
			permuteString(getOperators(), 0, getOperators().length() - 1, arr);
			return;
		}

		for (int j = i; j < arr.length; j++) {
			swap(arr, i, j);
			permute(arr, i + 1); // recurse call
			swap(arr, i, j); // backtracking
		}

	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public void permuteString(String str, int l, int r, int[] arr) {
		
		
		
		if (l == r) {

			// if values are integer implement integer
			String[] splitString = str.split("");
			
			combination.printCombination(arr, arr.length, 4, splitString);
			
		} else {
			for (int i = l; i <= r; i++) {
				str = swapString(str, l, i);
				permuteString(str, l + 1, r, arr);
				str = swapString(str, l, i);
			}

		}

	}
	/*****************************************************************************************/

	/*****************************************************************************************
	 * 
	 * STRING PERMUTATION
	 * 
	 *****************************************************************************************/
	public void permute(String[] arr, int i) {

		if (i == arr.length) {

			permuteString(getOperators(), 0, getOperators().length() - 1, arr);

			return;
		}
		for (int j = i; j < arr.length; j++) {
			swap(arr, i, j);
			permute(arr, i + 1); // recurse call
			swap(arr, i, j); // backtracking
		}

	}
	
	public void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void permuteString(String str, int l, int r, String[] arr) {
		if (l == r) {

			String[] splitString = str.split("");

			combination.printCombination(arr, arr.length, 4, splitString);

		} else {
			for (int i = l; i <= r; i++) {
				str = swapString(str, l, i);
				permuteString(str, l + 1, r, arr);
				str = swapString(str, l, i);
			}

		}
	}
	/*****************************************************************************************/
	
	public String swapString(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	

}
