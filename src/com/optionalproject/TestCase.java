package com.optionalproject;

public class TestCase {

	public static void main(String[] args) throws Exception {
		Process process = new Process(true);
		process.addProcessType(new Multiplication());
		process.addProcessType(new Addition());
		process.addProcessType(new Subtraction());

		String expression = "(((N + A) * R) - R)";
		System.out.println();
		System.out.println(expression + " = " + process.processResult(expression));		

	}

}
