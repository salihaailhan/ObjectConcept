package com.compositepattern;
public class AdditionExpressionNode extends BinaryExpressionNode {

	AdditionExpressionNode(ExpressionNode leftNode, ExpressionNode rightNode)
	{
		super(leftNode, rightNode);
	}
	
	@Override
	double operator(double value1, double value2) 
	{
		return value1 + value2;
	}

}
