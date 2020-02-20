package com.homework1;
public class InsertVariables {
		
	public String inVariable(String inString, String wantValue) {
		String outString = "";
		int[] arrOutInteger = { 0, 0, 0, 0 };

		String[] arrOfString = inString.split(",", 4);

		GetSetMethods getSetMethods = new GetSetMethods(wantValue, 1000000);
		Recursive recursive = new Recursive(wantValue, 1000000);

		System.out.println("test getWantValue : " + getSetMethods.getWantValue());

		if (isInteger(arrOfString[0])) {

			for (int i = 0; i < arrOutInteger.length; i++) {
				arrOutInteger[i] = Integer.parseInt(arrOfString[i]);
			}

			recursive.permute(arrOutInteger, 0);
			System.out.println(getSetMethods.getConString());

		} else {

			recursive.permute(arrOfString, 0);
			System.out.println(getSetMethods.getConString());

		}

		return outString;

	}



	// are values the integer
	public static boolean isInteger(String s) {
		return isInteger(s, 10);
	}

	public static boolean isInteger(String s, int radix) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

}
