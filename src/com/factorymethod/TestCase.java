package com.factorymethod;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapePattern shapePattern = new ShapePattern();
		
		// get an object of Circle and call its draw method
		ShapeFactoryMethod shape1 = shapePattern.getShape("CIRCLE");
		
		// call draw method of Circle
		shape1.draw();
		
		// get an object of Rectangle and call its draw method
		ShapeFactoryMethod shape2 = shapePattern.getShape("RECTANGLE");
		
		// call draw method of Rectangle
		shape2.draw();

		// get an object of Square and call its draw method
		ShapeFactoryMethod shape3 = shapePattern.getShape("SQUARE");
		
		// call draw method of Square
		shape3.draw();		
	}

}
