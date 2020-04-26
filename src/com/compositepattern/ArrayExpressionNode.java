package com.compositepattern;
public abstract class ArrayExpressionNode extends ExpressionNode {
	private final double[] arr;
	
	ArrayExpressionNode(double[] arr)
	{
		this.arr = arr;
	}
		
	double[] getArray()
	{
		return arr;
	}
}
