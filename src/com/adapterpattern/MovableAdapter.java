package com.adapterpattern;

public interface MovableAdapter {
	// return speed in KM/h
	double getSpeed();
}

//public class MovableAdapterImpl implements MovableAdapter {
//
//	private Movable luxuryCars;
//
//	@Override
//	public double getSpeed() {
//		
//		return convertMPHtoKMH(luxuryCars.getSpeed());
//	}
//	
//	private double convertMPHtoKMH(double mph) {
//		return mph * 1.60934;
//	}
//	
//}
