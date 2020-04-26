package com.compositepattern;
public class ValueExpressionNode extends UnaryExpressionNode {
	private double value;
	
	ValueExpressionNode(double value)
	{
		this.value = value;
	}
	
	@Override
	double evaluate() 
	{
		return value;
	}

}
