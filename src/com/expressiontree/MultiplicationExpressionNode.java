package com.expressiontree;

public class MultiplicationExpressionNode extends BinaryExpressionNode {

	MultiplicationExpressionNode(ExpressionNode leftNode, ExpressionNode rightNode) {
		super(leftNode, rightNode);
	}

	@Override
	double operator(double value1, double value2) {
		return value1 * value2;
	}

}
