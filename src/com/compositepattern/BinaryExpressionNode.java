package com.compositepattern;
public abstract class BinaryExpressionNode extends ExpressionNode {
	final ExpressionNode leftNode;
	final ExpressionNode rightNode;
		
	BinaryExpressionNode(ExpressionNode leftNode, ExpressionNode rightNode)
	{
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	@Override
	double evaluate() 
	{
		return operator(leftNode.evaluate(), rightNode.evaluate());
	}

	abstract double operator(double value1, double value2);
}
