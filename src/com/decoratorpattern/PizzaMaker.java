package com.decoratorpattern;

public class PizzaMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecPatternPizza basicPizza = new TomatoSouce(new Mozzarella(new PlainPizza()));
		
		System.out.println("Ingredients: " + basicPizza.getDescription());
		
		System.out.println("Price: " + basicPizza.getCost());
	}

}
