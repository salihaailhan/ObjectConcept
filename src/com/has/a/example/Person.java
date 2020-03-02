package com.has.a.example;

public abstract class Person {
	public final String name;
	public final String surname;
	public final IdentityCard identityCard = new IdentityCard();

	Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getFullName() {
		return name + " " + surname;
	}

	public void eat(FoodPlace foodPlace) {
		foodPlace.eat("Menemen");
	}
}