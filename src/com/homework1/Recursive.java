package com.homework1;

public class Recursive extends GetSetMethods {

	int countValue = 0;

	public Recursive(String wValue, String cValue) {
		// TODO Auto-generated constructor stub
		super(wValue, cValue);

	}

	CalculateValues calculateValues = new CalculateValues();

	// https://stackoverflow.com/questions/13218019/generating-permutations-of-an-int-array-using-java-error
	// int[] arr = {1, 2, 3,4};
	// permuteInteger(arr, 0);
	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

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

	// String str = "ABC";
	// int n = str.length();
	// if values are integer implement integer
	// permuteString(str, 0, n - 1);

	public void permuteString(String str, int l, int r, int[] arr) {

		if (l == r) {

			// if values are integer implement integer
			String[] splitString = str.split("");
			int conc = calculateValues.calculate(calculateValues
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
			countValue++;
			if (countValue == 144) {
				System.out.println(getConString());
			}
		} else {
			for (int i = l; i <= r; i++) {
				str = swapString(str, l, i);
				permuteString(str, l + 1, r, arr);
				str = swapString(str, l, i);
			}

		}

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

	// https://stackoverflow.com/questions/13218019/generating-permutations-of-an-int-array-using-java-error
	// int[] arr = {1, 2, 3,4};
	// permuteInteger(arr, 0);
	public void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

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

	// String str = "ABC";
	// int n = str.length();
	// if values are char implement string
	// permuteString(str, 0, n - 1);
	public void permuteString(String str, int l, int r, String[] arr) {
		if (l == r) {

			String[] splitString = str.split("");

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
			countValue++;
			if (countValue == 144) {
				System.out.println(getConString());
			}
		} else {
			for (int i = l; i <= r; i++) {
				str = swapString(str, l, i);
				permuteString(str, l + 1, r, arr);
				str = swapString(str, l, i);
			}

		}
	}

	public String swapString(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
