package com.homework1;

public class Combination extends GetSetMethods {
	
	public Combination(String wValue, String cValue) {
		// TODO Auto-generated constructor stub
		super(wValue, cValue);
	}
	
	CalculateValues calculateValues = new CalculateValues();

	/***************************************************************************************************
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index --->
	 * Current index in data[] r ---> Size of a combination to be printed
	 ***************************************************************************************************/
	public void combinationUtil(double[] arr, double[] data, int start, int end, int index, int r,
			String[] splitString) {
		// Current combination is ready to be printed, print it
		if (index == r) {

			double conc = calculateValues.calculate(calculateValues
					.calculate(calculateValues.calculate(data[0], data[1], splitString[0]), data[2], splitString[1]),
					data[3], splitString[2]);

			String strConc = "(((" + data[0] + " " + splitString[0] + " " + data[1] + ")" + " " + splitString[1] + " "
					+ data[2] + ")" + " " + splitString[2] + " " + data[3] + ")" + ")" + " > " + "(("
					+ calculateValues.calculate(data[0], data[1], splitString[0]) + " " + splitString[1] + " " + data[2]
					+ ")" + " " + splitString[2] + " " + data[3] + ")" + " > " + "("
					+ calculateValues.calculate(
							calculateValues.calculate(data[0], data[1], splitString[0]), data[2], splitString[1])
					+ " " + splitString[2] + " " + data[3] + ")" + " > "
					+ calculateValues.calculate(
							calculateValues.calculate(calculateValues.calculate(data[0], data[1], splitString[0]), data[2],
									splitString[1]),
							data[3], splitString[2]);

			if (conc == Double.parseDouble(getWantValue())) {

				setConString(strConc);

			} else {
				if (Double.parseDouble(getWantValue()) - conc < 0) { // if nearest values less zero
					if (((Double.parseDouble(getWantValue()) - conc) * -1)
							+ ((Double.parseDouble(getWantValue()) - conc) * -1) < getNearValue()) {
						setNearValue(((Double.parseDouble(getWantValue()) - conc) * -1)
								+ ((Double.parseDouble(getWantValue()) - conc) * -1));
						setConString(strConc);
					}
				} else {
					if (Double.parseDouble(getWantValue()) - conc < getNearValue()) {
						setNearValue(Double.parseDouble(getWantValue()) - conc);
						setConString(strConc);
					}
				}
			}
			
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, splitString);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	public void printCombination(double[] arr, int n, int r, String[] splitString) {
		// A temporary array to store all combination one by one
		double[] data = new double[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r, splitString);
	}
	
	/***************************************************************************************************
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index --->
	 * Current index in data[] r ---> Size of a combination to be printed
	 ***************************************************************************************************/
	public void combinationUtil(int[] arr, int[] data, int start, int end, int index, int r,
			String[] splitString) {
		// Current combination is ready to be printed, print it
		if (index == r) {

			double conc = calculateValues.calculate(calculateValues
					.calculate(calculateValues.calculate(data[0], data[1], splitString[0]), data[2], splitString[1]),
					data[3], splitString[2]);

			String strConc = "(((" + data[0] + " " + splitString[0] + " " + data[1] + ")" + " " + splitString[1] + " "
					+ data[2] + ")" + " " + splitString[2] + " " + data[3] + ")" + ")" + " > " + "(("
					+ calculateValues.calculate(data[0], data[1], splitString[0]) + " " + splitString[1] + " " + data[2]
					+ ")" + " " + splitString[2] + " " + data[3] + ")" + " > " + "("
					+ calculateValues.calculate(
							calculateValues.calculate(data[0], data[1], splitString[0]), data[2], splitString[1])
					+ " " + splitString[2] + " " + data[3] + ")" + " > "
					+ calculateValues.calculate(
							calculateValues.calculate(calculateValues.calculate(data[0], data[1], splitString[0]), data[2],
									splitString[1]),
							data[3], splitString[2]);

			if (conc == Integer.parseInt(getWantValue())) {

				setConString(strConc);

			} else {
				if (Integer.parseInt(getWantValue()) - conc < 0) { // if nearest values less zero
					if (((Integer.parseInt(getWantValue()) - conc) * -1)
							+ ((Integer.parseInt(getWantValue()) - conc) * -1) < getNearValue()) {
						setNearValue(((Integer.parseInt(getWantValue()) - conc) * -1)
								+ ((Integer.parseInt(getWantValue()) - conc) * -1));
						setConString(strConc);
					}
				} else {
					if (Integer.parseInt(getWantValue()) - conc < getNearValue()) {
						setNearValue(Integer.parseInt(getWantValue()) - conc);
						setConString(strConc);
					}
				}
			}
			
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, splitString);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	public void printCombination(int[] arr, int n, int r, String[] splitString) {
		// A temporary array to store all combination one by one
		int[] data = new int[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r, splitString);
	}
	
	/***************************************************************************************************
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index --->
	 * Current index in data[] r ---> Size of a combination to be printed
	 ***************************************************************************************************/
	public void combinationUtil(String[] arr, String[] data, int start, int end, int index, int r,
			String[] splitString) {
		// Current combination is ready to be printed, print it
		if (index == r) {

			String conc = calculateValues.calculate(calculateValues
					.calculate(calculateValues.calculate(arr[0], arr[1], splitString[0]), arr[2], splitString[1]),
					arr[3], splitString[2]);
			String strConc = "(((" + arr[0] + " " + splitString[0] + " " + arr[1] + ")" + " " + splitString[1] + " "
					+ arr[2] + ")" + " " + splitString[2] + " " + arr[3] + ")" + ")" + " > " + "(("
					+ calculateValues.calculate(arr[0], arr[1], splitString[0]) + " " + splitString[1] + " " + arr[2]
					+ ")" + " " + splitString[2] + " " + arr[3] + ")" + " > " + "("
					+ calculateValues.calculate(
							calculateValues.calculate(arr[0], arr[1], splitString[0]), arr[2], splitString[1])
					+ " " + splitString[2] + " " + arr[3] + ")" + " > "
					+ calculateValues.calculate(
							calculateValues.calculate(calculateValues.calculate(arr[0], arr[1], splitString[0]), arr[2],
									splitString[1]),
							arr[3], splitString[2]);

			if (stringCompare(conc, getWantValue()) == 0) {
				setConString(strConc);
			} else {
				if (stringCompare(conc, getWantValue()) < getNearValue()) {
					setNearValue(stringCompare(conc, getWantValue()));
					setConString(strConc);
				}
			}
			
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, splitString);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	public void printCombination(String[] arr, int n, int r, String[] splitString) {
		// A temporary array to store all combination one by one
		String[] data = new String[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r, splitString);
	}
	
	// This method compares two strings
	// lexicographically without using
	// library functions
	public static int stringCompare(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();
		int lmin = Math.min(l1, l2);

		for (int i = 0; i < lmin; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch != str2_ch) {
				return str1_ch - str2_ch;
			}
		}

		// Edge case for strings like
		// String 1="Geeks" and String 2="Geeksforgeeks"
		if (l1 != l2) {
			return l1 - l2;
		}

		// If none of the above conditions is true,
		// it implies both the strings are equal
		else {
			return 0;
		}
	}
}
