package com.compositepattern;
public class SqrtExpressionNode extends UnaryExpressionNode {
	final ExpressionNode childNode;
	
	SqrtExpressionNode(ExpressionNode childNode)
	{
		this.childNode = childNode;
	}
	
	@Override
	double evaluate() 
	{
		return Math.sqrt(childNode.evaluate());
	}
	
}
