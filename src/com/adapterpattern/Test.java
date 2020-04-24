package com.adapterpattern;

public class Test {
	
	public static void main(String[] args) {
		
		Movable bugattiVeyron = new BugattiVeyron();
		MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
		
		System.out.println("MHP get speed : " + bugattiVeyron.getSpeed());
		System.out.println();
		System.out.println("KM get speed : " + bugattiVeyronAdapter.getSpeed());
		
	}
}
