package com.decoratorpattern;

public class TomatoSouce extends ToppingDecorator {

	public TomatoSouce(DecPatternPizza newPizza) {
		super(newPizza);
		
		System.out.println("Adding Souce");

	}
	
	public String getDescription() {

		return tempPizza.getDescription() + ", Tomato Souce";
	}

	public double getCost() {

		return tempPizza.getCost() + .35;
	}

}
