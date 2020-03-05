package com.abstractfactory;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory computerAbstractFactory) {
		return computerAbstractFactory.createComputer();
	}
}
