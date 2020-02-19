package com.cardesigntest;

public class DisplayPanel {
	private CarState carState;
	private final ControlPanel controlPanel;

	DisplayPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	void fetchCarState() {
		carState = controlPanel.getCarState();
	}

	boolean isRunning() {
		return carState.running;
	}

	double getSpeed() {
		return carState.speed;
	}

	double getMaximumSpeed() {
		return carState.maximumSpeed;
	}

	double getSteeringWheelOrientation() {
		return carState.orientation;
	}

	/*
	 * Home study: implement Fuel gauge, Temperature gauge, Car trip meter, Rev
	 * counter
	 * 
	 * Speedometer: The speedometer shows how fast the person driving the car is
	 * driving. Fuel gauge: Used to show how much petrol or diesel the car has left.
	 * Temperature gauge: Shows how hot the cars engine is. Car trip meter: This
	 * shows the driver how many miles the journey has took. Rev counter: The rev
	 * counter is an instrument measuring the rotation speed of a shaft or disk.
	 */
}
