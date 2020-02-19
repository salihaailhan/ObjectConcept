package com.expressiontree;

public class DivisionExpressionNode extends BinaryExpressionNode {

	DivisionExpressionNode(ExpressionNode leftNode, ExpressionNode rightNode) {
		super(leftNode, rightNode);
	}

	@Override
	double operator(double value1, double value2) {
		return value1 / value2;
	}

}
