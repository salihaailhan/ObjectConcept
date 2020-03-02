package com.has.a.example;

public class Restaurant extends FoodPlace {
	@Override
	void eat(String foodName) {
		System.out.println("You eat " + foodName + ", was it delicious? You need to pay 10 TL.");
	}
}
