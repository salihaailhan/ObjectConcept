package com.optionalproject;

public class RightParentheses extends OperatorAbstract {
	public char type() {
		return RIGHT_PARENTHESES;
	}

	public int priority() {
		return PARENTHESES;
	}
}