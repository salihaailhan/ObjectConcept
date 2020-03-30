package com.factorymethod;

public class ShapePattern {

	public ShapeFactoryMethod getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new CircleFactoryMethod();
		} else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new RectangleFactoryMethod();
		} else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new SquareFactoryMethod();
		}
		
		return null;
	}
}
