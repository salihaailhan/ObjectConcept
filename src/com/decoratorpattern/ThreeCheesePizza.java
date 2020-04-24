package com.decoratorpattern;

public class ThreeCheesePizza extends Pizza{

	@Override
	public void setDescription(String newDescription) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Mozzarella, Fontina, Parmesan, Cheese Pizza";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 10.00;
	}

	@Override
	public boolean hasFontina() {
		// TODO Auto-generated method stub
		return false;
	}

}
