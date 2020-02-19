package com.cardesigntest;

public class CarState {
	final double maximumSpeed;
	final boolean running;
	final double speed;
	final double orientation;

	CarState(double maximumSpeed, boolean running, double speed, double orientation) {
		this.maximumSpeed = maximumSpeed;
		this.running = running;
		this.speed = speed;
		this.orientation = orientation;
	}
}
