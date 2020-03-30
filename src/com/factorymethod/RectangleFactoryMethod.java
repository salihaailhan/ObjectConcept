package com.factorymethod;

public class RectangleFactoryMethod implements ShapeFactoryMethod {

	@Override
	public void draw() {
		
		System.out.println("Inside Rectangle::draw() method.");
		
	}
}
