package com.has.a.example;

public class Kitchen extends FoodPlace {
	@Override
	void eat(String foodName) {
		System.out.println(foodName + " was good, now I need to clean the kitchen.");
	}
}
