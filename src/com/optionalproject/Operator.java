package com.optionalproject;

public interface Operator {
	static final int LOWEST = 11;
	static final int LOW = 10;
	static final int MIDDLE = 5;
	static final int HIGH = 1;
	static final int PARENTHESES = 0;

	static final char LEFT_PARENTHESES = '(';
	static final char RIGHT_PARENTHESES = ')';

	char type();

	int priority();
}