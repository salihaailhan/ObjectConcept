package com.cardesigntest;

public class Car {
	final Door doors[];
	private final ControlPanel controlPanel;
	private final DisplayPanel displayPanel;

	Car(Door doors[], ControlPanel controlPanel, DisplayPanel displayPanel) {
		this.doors = doors;
		this.controlPanel = controlPanel;
		this.displayPanel = displayPanel;
	}

	boolean isOpen() {
		// Peel has single door
		return (doors.length == 1 && !doors[0].isLocked());
	}

	ControlPanel getControlPanel() {
		if (isOpen())
			return controlPanel;
		else
			return null;
	}

	DisplayPanel getDisplayPanel() {
		if (isOpen())
			return displayPanel;
		else
			return null;
	}
}
