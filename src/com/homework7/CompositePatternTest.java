package com.homework7;

public class CompositePatternTest {

	public static void main(String[] args) {

		Food menemen = new Menemen();
		System.out.println(menemen.getRecipe());
		System.out.println("Calorie of " + menemen.getName() + " is " + menemen.calorie());
		System.out.println();

		Food menemenWithBologna = new FoodWithBologna(new Menemen(), 0.075);
		System.out.println(menemenWithBologna.getRecipe());
		System.out.println("Calorie of " + menemenWithBologna.getName() + " is " + menemenWithBologna.calorie());
		System.out.println();

		Food menemenWithCheese = new FoodWithCheese(new Menemen(), 0.06);
		System.out.println(menemenWithCheese.getRecipe());
		System.out.println("Calorie of " + menemenWithCheese.getName() + " is " + menemenWithCheese.calorie());
		System.out.println();

		Food karniyarikWithCheese = new FoodWithCheese(new Karniyarik(), 0.06);
		System.out.println(karniyarikWithCheese.getRecipe());
		System.out.println("Calorie of " + karniyarikWithCheese.getName() + " is " + karniyarikWithCheese.calorie());
		System.out.println();

		Food menemenWithPepper = new FoodWithPepper(new Menemen(), 0.03);
		System.out.println(menemenWithPepper.getRecipe());
		System.out.println("Calorie of " + menemenWithPepper.getName() + " is " + menemenWithPepper.calorie());
		System.out.println();

		Food menemenWithBolognaAndCheese = new FoodWithCheese(new FoodWithBologna(new Menemen(), 0.075), 0.04);
		System.out.println(menemenWithBolognaAndCheese.getRecipe());
		System.out.println(
				"Calorie of " + menemenWithBolognaAndCheese.getName() + " is " + menemenWithBolognaAndCheese.calorie());
		System.out.println();

		Food menemenWithBolognaAndCheeseAndPepper = new FoodWithPepper(
				new FoodWithCheese(new FoodWithBologna(new Menemen(), 0.075), 0.04), 0.25);
		System.out.println(menemenWithBolognaAndCheeseAndPepper.getRecipe());
		System.out.println("Calorie of " + menemenWithBolognaAndCheeseAndPepper.getName() + " is "
				+ menemenWithBolognaAndCheeseAndPepper.calorie());
		System.out.println();

	}

}

abstract class Food {
	abstract String getName();

	abstract String getRecipe();

	abstract double calorie();
}

class Menemen extends Food {
	final double tomatos = 0.250;
	final double onion = 0.05;
	final int egg = 2;

	@Override
	String getName() {
		return "Menemen";
	}

	@Override
	String getRecipe() {
		return "Tomato x " + tomatos + " gram \n" + "Onion x " + onion + " gram \n" + +egg + " units Egg";
	}

	@Override
	double calorie() {
		return tomatos * 100 + onion * 200 + egg * 125;
	}
}

class Karniyarik extends Food {
	final double tomatos = 0.250;
	final double onion = 0.05;
	final double meat = 0.10;

	@Override
	String getName() {
		return "Karniyarik";
	}

	@Override
	String getRecipe() {
		return "Tomato x " + tomatos + " gram \n" + "Onion x " + onion + " gram \n" + "Meat x " + meat + " gram";
	}

	@Override
	double calorie() {
		return tomatos * 100 + onion * 200 + meat * 90;
	}
}

abstract class FoodDecarator extends Food {
	private Food food;

	FoodDecarator(Food food) {
		this.food = food;
	}

	@Override
	String getName() {
		return food.getName();
	}

	double calorie() {
		return food.calorie();
	}

	String getRecipe() {
		return food.getRecipe();
	}

}

class FoodWithBologna extends FoodDecarator {
	final double bologna;

	FoodWithBologna(Food food, double amount) {
		super(food);
		this.bologna = amount;
	}

	@Override
	String getName() {
		return super.getName() + " + Bologna";
	}

	String getRecipe() {
		return super.getRecipe() + "\n" + "Bologna x " + bologna + " gram";
	}

	double calorie() {
		return super.calorie() + bologna * 150;
	}
}

class FoodWithCheese extends FoodDecarator {
	final double cheese;

	FoodWithCheese(Food food, double amount) {
		super(food);
		this.cheese = amount;
	}

	@Override
	String getName() {
		return super.getName() + " + Cheese";
	}

	String getRecipe() {
		return super.getRecipe() + "\n" + "Cheese x " + cheese + " gram";
	}

	double calorie() {
		return super.calorie() + cheese * 200;
	}
}

class FoodWithPepper extends FoodDecarator {
	final double pepper;

	FoodWithPepper(Food food, double amount) {
		super(food);
		this.pepper = amount;
	}

	@Override
	String getName() {
		return super.getName() + " + Pepper";
	}

	String getRecipe() {
		return super.getRecipe() + "\n" + "Pepper x " + pepper + " gram";
	}

	double calorie() {
		return super.calorie() + pepper * 50;
	}

}
