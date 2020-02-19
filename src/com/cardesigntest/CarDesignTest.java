package com.cardesigntest;

public class CarDesignTest {

	public static void main(String[] args) {
		CarDesignTest carDesignTest = new CarDesignTest();
		carDesignTest.test();
	}
	
	void test() {
		CarFactory carFactory = new CarFactory();
		ConcreteCar concreteCar = carFactory.produce();
		
		Car car = concreteCar.car;
		Key key = concreteCar.key;
		
		System.out.println("Car locked (after creation) is " + car.doors[0].isLocked());
		System.out.println("Access to control panel : " + car.getControlPanel());
		System.out.println("Access to display panel : " + car.getDisplayPanel());
		System.out.println();

		Lock fakeLock = new Lock();
		Key fakeKey = new Key(fakeLock);
		
		car.doors[0].unlock(fakeKey);
		System.out.println("Car locked (with fake key use) is " + car.doors[0].isLocked());
		System.out.println("Access to control panel : " + car.getControlPanel());
		System.out.println("Access to display panel : " + car.getDisplayPanel());
		System.out.println();
		
		car.doors[0].unlock(key);
		System.out.println("Car locked (with real key use) is " + car.doors[0].isLocked());
		System.out.println("Access to control panel : " + car.getControlPanel());
		System.out.println("Access to display panel : " + car.getDisplayPanel());
		System.out.println();
		
		ControlPanel controlPanel = car.getControlPanel();
		DisplayPanel displayPanel = car.getDisplayPanel();
				
		controlPanel.turnOnEngine();
		System.out.println("Car is open : " + car.isOpen());
		
		double pressure = 0.90;
		while (controlPanel.pushAccelerator(pressure) > 0) {
			displayPanel.fetchCarState();
			System.out.println("Car speed is " + displayPanel.getSpeed());
		}		
	}

}
