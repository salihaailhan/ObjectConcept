package com.decoratorpattern;

public class Mozzarella extends ToppingDecorator {

	public Mozzarella(DecPatternPizza newPizza) {
		super(newPizza);
		
		System.out.println("Adding Dough");
		
		System.out.println("Adding Moz");
	}
	
	public String getDescription() {

		return tempPizza.getDescription() + ", Mozzarella";
	}

	public double getCost() {

		return tempPizza.getCost() + .50;
	}

}
