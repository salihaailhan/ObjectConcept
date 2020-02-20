package com.homework1;

public class CalculateValues {
	public int calculate(int a, int b, String opt) {
		int conc = 0;
		switch (opt) {
		case "*":
			conc = a * b;
			break;
		case "+":
			conc = a + b;
			break;
		case "-":
			conc = a - b;
			break;
		default:
			break;
		}

		return conc;
	}
	
	public String calculate(String a, String b, String opt) {
		String conc = "";
		// Creating array of string length 
        char[] ch = new char[a.length()]; 
  
        // Copy character by character into array 
        for (int i = 0; i < a.length(); i++) { 
            ch[i] = a.charAt(i); 
        } 
        
		switch (opt) {
		case "*":

	  
	        // adding content of array 
	        for (char c : ch) {
	        	conc += c+b;
	        } 
			break;
		case "+":
			conc = a + b;
			break;
		case "-":	  
	        // subtraction content of array 
	        for (char c : ch) {
	        	if(c != b.charAt(0)) {
	        		conc += c;
	        	}
	        	
	        } 			
			break;
		default:
			break;
		}

		return conc;
	}
}
