package com.optionalproject;

public class TestCase {

	public static void main(String[] args) throws Exception {
		Process process = new Process(true);
		process.addProcessType(new Multiplication());
		process.addProcessType(new Divition());
		process.addProcessType(new Addition());
		process.addProcessType(new Subtraction());

		String expression = "((((6 + 5) * 2) - 1) / 2)";
		System.out.println();
		System.out.println(expression + " = " + process.processResult(expression));		

	}

}
