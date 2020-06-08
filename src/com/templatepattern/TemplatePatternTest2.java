package com.templatepattern;

public class TemplatePatternTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaffeineBeverage coffee = new Coffee();
		CaffeineBeverage tea = new Tea();
		System.out.println("/********* Coffee *********/");
		coffee.boilWater();
		coffee.brew();
		coffee.pourInCup();
		coffee.addCondiments();
		System.out.println("/********* Coffee prepareRecipe() *********/");
		coffee.prepareRecipe();
		
		System.out.println("/********* Tea *********/");
		tea.boilWater();
		tea.brew();
		tea.pourInCup();
		tea.addCondiments();
		System.out.println("/********* Tea prepareRecipe() *********/");
		tea.prepareRecipe();
		
//		OUTPUT:
//			/********* Coffee *********/
//			Boiling Water
//			Dripping coffee though filter
//			Pouring into Cup
//			Adding Sugar and Milk
//			/********* Coffee prepareRecipe() *********/
//			Boiling Water
//			Dripping coffee though filter
//			Pouring into Cup
//			Adding Sugar and Milk
//			/********* Tea *********/
//			Boiling Water
//			Steeping the tea
//			Pouring into Cup
//			Adding Lemon
//			/********* Tea prepareRecipe() *********/
//			Boiling Water
//			Steeping the tea
//			Pouring into Cup
//			Adding Lemon
	}
}

abstract class CaffeineBeverage {
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	public void boilWater() {
		System.out.println("Boiling Water");
	}

	abstract void brew();

	public void pourInCup() {
		System.out.println("Pouring into Cup");
	}

	abstract void addCondiments();
}

class Coffee extends CaffeineBeverage {

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("Dripping coffee though filter");
	}

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Sugar and Milk");
	}

}

class Tea extends CaffeineBeverage {

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Lemon");
	}

}
