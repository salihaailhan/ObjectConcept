package com.decoratorpattern;

public class PlainPizza implements DecPatternPizza {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Thin Dough";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 4.00;
	}

}
