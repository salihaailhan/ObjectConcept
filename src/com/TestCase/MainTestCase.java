package com.TestCase;

public class MainTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr1[] = { 1, 2, 3 };
		int r1 = 2;
		int n1 = arr1.length;
		Combination.printCombination(arr1, n1, r1);
		
		System.out.println("/******************************************************/");
		
        int arr[] = {1, 2, 3}; 
        int r2 = 2; 
        int n2 = arr.length; 
        Combination.printCombi(arr, n2, r2); 
		
		System.out.println("/******************************************************/");
		
		int arr2[] = { 1, 2, 3 };
		int len = arr2.length;
		int L = 2;
		
		Permutation.print(arr2, len, L); // function call
		
		System.out.println("/******************************************************/");
		
        String str = "ABC"; 
        int n3 = str.length(); 
        Permutation permutation = new Permutation(); 
        permutation.permute(str, 0, n3 - 1);
	}

}
