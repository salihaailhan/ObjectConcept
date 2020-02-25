package com.optionalproject;

public class LeftParentheses extends OperatorAbstract {
	public char type() {
		return LEFT_PARENTHESES;
	}

	public int priority() {
		return PARENTHESES;
	}
}