package com.adapterpattern;

public class MovableAdapterImpl implements MovableAdapter {
	
	private Movable luxuryCars;
	
	MovableAdapterImpl(Movable lxryCars) {
		this.luxuryCars = lxryCars;
	}

	@Override
	public double getSpeed() {
	
		return convertMPHtoKMH(luxuryCars.getSpeed());
	}
	
	private double convertMPHtoKMH(double mph) {
		return mph * 1.60934;
	}
	
}
