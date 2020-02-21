package com.homework1;

public class InsertVariables {
	private String outString = "";
	private int[] arrOutInteger = { 0, 0, 0, 0 };
	private String inString;
	private String wantValue;

	public InsertVariables(String iString, String wValue) {
		// TODO Auto-generated constructor stub
		this.inString = iString;
		this.wantValue = wValue;
	}

	public String getOutString() {
		return outString;
	}

	public void setOutString(String outString) {
		this.outString = outString;
	}

	public int[] getArrOutInteger() {
		return arrOutInteger;
	}

	public void setArrOutInteger(int[] arrOutInteger) {
		this.arrOutInteger = arrOutInteger;
	}

	public String inVariable() {

		String[] arrOfString = inString.split(",", 4);

		Recursive recursive = new Recursive(wantValue, "");

		if (isInteger(arrOfString[0])) {

			for (int i = 0; i < arrOutInteger.length; i++) {
				arrOutInteger[i] = Integer.parseInt(arrOfString[i]);
			}

			recursive.permute(arrOutInteger, 0);
			

		} else {

			recursive.permute(arrOfString, 0);

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
