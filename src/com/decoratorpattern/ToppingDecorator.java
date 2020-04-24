package com.decoratorpattern;

abstract class ToppingDecorator implements DecPatternPizza {

	protected DecPatternPizza tempPizza;

	public ToppingDecorator(DecPatternPizza newPizza) {

		tempPizza = newPizza;
	}

	public String getDescription() {

		return tempPizza.getDescription();
	}

	public double getCost() {

		return tempPizza.getCost();
	}
}
