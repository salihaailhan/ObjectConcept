package com.homework7;

/*
In this homework you will use Composite Pattern to model a food menu.

Define a Food class. For example:

class Food {

   final String name;

   final double calorie;

   Food(String name, double calorie) {

      this.name = name;

      this.calorie = calorie;

   }

}

You can create Karniyarik with:   

Food karniyarik = new Food("Karniyarık", 170);

or

Food karniyarik = new Karniyarik();

using below extended class. Design issues are up to your creativity. 
Now you can add karniyarik instance to the foods list of the any Menu instance.

class Karniyarik extends Food {

   Karniyarik() {

      super("Karnıyarık", 170);

   }

}

A menu can contain single food or multiple foods (a list of foods), and a menu can contain sub menus. For example:

class Menu {

        //  student code (keep foods, keep sub-menus, etc.)

    double getCalorie( ) {

       // student code

    }

}

In the main method, show how your design works with a nice example. For example, 
I want to see a menu with some foods and sub menus (i.e. a dessert menu inside the 
		menu, and dessert menu contain a Cheescake, and Turkish dessert menu and 
		Arabic dessert menu) then I want to see the total calorie of the whole foods 
contained in the menu. Also, add more functionalities, i.e. number of sub-menus in the 
menu, number of foods in the menu (and invent one more functionality yourself).
*/

import java.util.*;

public class Homework7Solution {

	public static void main(String[] args) {
		FoodMenu dinnerMenu = new FoodMenu("Dinner menu for 4 May 2020"); 
		dinnerMenu.addFood(new Karniyarik());		// Karniyarik is 135 calories
		dinnerMenu.addFood(new GenericFood("Salad of the day", 50));
		dinnerMenu.addFood(new GenericFood("Special Soup of Chief", 75));
		
		FoodMenu dessertMenu = new FoodMenu("Dessert menu");
		dessertMenu.addFood(new GenericFood("Dessert of the day", 220));
		dessertMenu.addFood(new TurkishCoffee());	// Turkish coffee is only 5 calories
		
		FoodMenu arabicDessertMenu = new FoodMenu("Arabic dessert menu");
		arabicDessertMenu.addFood(new GenericFood("Baklava", 300));
		arabicDessertMenu.addFood(new GenericFood("Iran syrup", 70));
		
		dessertMenu.addFood(arabicDessertMenu);
		dinnerMenu.addFood(dessertMenu);
		
		System.out.println(dinnerMenu);			// calls toString() method

		System.out.println("Total calorie of " + dinnerMenu.name + " is " + dinnerMenu.getCalorie());
		System.out.println("Number of menus in " + dinnerMenu.name + " is " + dinnerMenu.getCountOfFood(FoodMenu.class));
		System.out.println("Number of generic foods in " + dinnerMenu.name + " is " + dinnerMenu.getCountOfFood(GenericFood.class));		
	}

}

abstract class Food {
	final String name;

	Food(String name) {
		this.name = name;
	}
	
	abstract double getCalorie();
	
	int getCountOfFood(Class classType) {
		return (this.getClass() ==  classType ? 1 : 0);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Food) {
			Food foodObj = (Food)obj;
			return name.equals(foodObj.name);
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return name + " (calorie = " + getCalorie() + ") \n";
	}
}

class GenericFood extends Food {
	private final double calorie;
	
	GenericFood(String name, double calorie) {
		super(name);
		this.calorie = calorie;
	}
	
	@Override
	double getCalorie() {
		return calorie;
	}
}

class Karniyarik extends Food {
	
	Karniyarik() {
		super("Karniyarik");
	}
	
	@Override
	double getCalorie() {
		return 135.0;
	}
}

class TurkishCoffee extends Food {
	
	TurkishCoffee() {
		super("Türk Kahvesi");
	}
	
	@Override
	double getCalorie() {
		return 5.0;
	}
}

class FoodMenu extends Food {
	private List<Food> foods = new ArrayList<Food>();

	FoodMenu(String name) {
		super(name);
	}
	
	void addFood(Food food) {
		foods.add(food);
	}
	
	void removeFood(Food food) {
		foods.remove(food);
	}
	
	@Override
    double getCalorie() {
		double calorie = 0.0;
		for (Food food : foods) {
			calorie += food.getCalorie();
		}		
		return calorie;
    }
	
	@Override
	int getCountOfFood(Class classType) {
		int count = super.getCountOfFood(classType);
		for (Food food : foods) {
			count += food.getCountOfFood(classType);
		}		
		return count;		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("* " + name + "\n");
		for (Food food : foods) {
			sb.append(food);
		}		
		
		return sb.toString();
	}	
	
}
