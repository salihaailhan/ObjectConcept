package com.templatepattern;

public class TemplatePatternTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItalianHoagie cust12Hoagie = new ItalianHoagie();

		cust12Hoagie.makeSandwich();

		System.out.println();

		VeggieHoagie cust13Hoagie = new VeggieHoagie();

		cust13Hoagie.makeSandwich();
	}

}

//A Template Method Pattern contains a method that provides
//the steps of the algorithm. It allows subclasses to override 
//some of the methods

abstract class Hoagie {

	boolean afterFirstCondiment = false;

	// This is the Template Method
	// Declare this method final to keep subclasses from
	// changing the algorithm

	final void makeSandwich() {

		cutBun();

		if (customerWantsMeat()) {

			addMeat();

			// Here to handle new lines for spacing
			afterFirstCondiment = true;

		}

		if (customerWantsCheese()) {

			if (afterFirstCondiment) {
				System.out.print("\n");
			}

			addCheese();

			afterFirstCondiment = true;

		}

		if (customerWantsVegetables()) {

			if (afterFirstCondiment) {
				System.out.print("\n");
			}

			addVegetables();

			afterFirstCondiment = true;

		}

		if (customerWantsCondiments()) {

			if (afterFirstCondiment) {
				System.out.print("\n");
			}

			addCondiments();

			afterFirstCondiment = true;

		}

		wrapTheHoagie();

	}

	// These methods must be overridden by the extending subclasses

	abstract void addMeat();

	abstract void addCheese();

	abstract void addVegetables();

	abstract void addCondiments();

	public void cutBun() {

		System.out.println("The Hoagie is Cut");

	}

	// These are called hooks
	// If the user wants to override these they can

	// Use abstract methods when you want to force the user
	// to override and use a hook when you want it to be optional

	boolean customerWantsMeat() {
		return true;
	}

	boolean customerWantsCheese() {
		return true;
	}

	boolean customerWantsVegetables() {
		return true;
	}

	boolean customerWantsCondiments() {
		return true;
	}

	public void wrapTheHoagie() {

		System.out.println("\nWrap the Hoagie");

	}

	public void afterFirstCondiment() {

		System.out.println("\n");

	}

}

class ItalianHoagie extends Hoagie {

	String[] meatUsed = { "Salami", "Pepperoni", "Capicola Ham" };
	String[] cheeseUsed = { "Provolone" };
	String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
	String[] condimentsUsed = { "Oil", "Vinegar" };

	public void addMeat() {

		System.out.print("Adding the Meat: ");

		for (String meat : meatUsed) {

			System.out.print(meat + " ");

		}

	}

	public void addCheese() {

		System.out.print("Adding the Cheese: ");

		for (String cheese : cheeseUsed) {

			System.out.print(cheese + " ");

		}

	}

	public void addVegetables() {

		System.out.print("Adding the Vegetables: ");

		for (String vegetable : veggiesUsed) {

			System.out.print(vegetable + " ");

		}

	}

	public void addCondiments() {

		System.out.print("Adding the Condiments: ");

		for (String condiment : condimentsUsed) {

			System.out.print(condiment + " ");

		}

	}
}

class VeggieHoagie extends Hoagie {

	String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
	String[] condimentsUsed = { "Oil", "Vinegar" };

	boolean customerWantsMeat() {
		return false;
	}

	boolean customerWantsCheese() {
		return false;
	}

	public void addVegetables() {

		System.out.print("Adding the Vegetables: ");

		for (String vegetable : veggiesUsed) {

			System.out.print(vegetable + " ");

		}

	}

	public void addCondiments() {

		System.out.print("Adding the Condiments: ");

		for (String condiment : condimentsUsed) {

			System.out.print(condiment + " ");

		}

	}

	void addMeat() {
	}

	void addCheese() {
	}
}