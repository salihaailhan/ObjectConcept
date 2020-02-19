package com.expressiontree;

public class MinExpressionNode extends ArrayExpressionNode {

	MinExpressionNode(double[] arr) {
		super(arr);
	}

	@Override
	double evaluate() {
		double minimumValue = Double.POSITIVE_INFINITY;

		for (double x : getArray()) {
			if (x < minimumValue) {
				minimumValue = x;
			}
		}

		return minimumValue;
	}
}
