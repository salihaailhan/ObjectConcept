package com.cardesigntest;

public class CarFactory {
	ConcreteCar produce() {
		Lock lock = new Lock();
		Door carDoor = new Door(lock);
		Key carKey = new Key(lock);

		Door doors[] = { carDoor };
		final double peelMaximumSpeed = 75.0;
		ControlPanel controlPanel = new ControlPanel(peelMaximumSpeed);
		DisplayPanel displayPanel = new DisplayPanel(controlPanel);

		Car car = new Car(doors, controlPanel, displayPanel);

		ConcreteCar createdCar = new ConcreteCar(car, carKey);

		return createdCar;
	}
}

class ConcreteCar {
	final Car car;
	final Key key;

	public ConcreteCar(Car car, Key key) {
		// TODO Auto-generated constructor stub
		this.car = car;
		this.key = key;
	}
}
