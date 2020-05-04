package com.homework7;

import java.util.*;

public class CompositePatternFoodTest {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.menus.add(new Food("Menemen", 170.25));
		menu.menus.add(new Food("Karniyarik", 16.50));
		menu.create();
		
		System.out.println(menu.getName());
		
	}

}

abstract class Foods {
	abstract String getName();

	public String create() {
		return getName();
	}
}

class Menu extends Foods {
	
	final List<Foods> menus = new ArrayList<Foods>();
	
	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		
		for (Foods foods : menus) {
			sb.append(foods.getName());
		}
		
		return sb.toString();
	}

}

class Food extends Foods {
	
	final String name;
	final double calorie;
	
	Food(String name, double calorie) {
		this.name = name;
		this.calorie = calorie;
	}
	
	@Override
	String getName() {
		return name + " " + "Calorie : " + calorie + "\n";
	}
}

