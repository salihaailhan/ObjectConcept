package com.abstractfactory;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAbstractFactory();
	}
	
	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 Ghz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "3.0 Ghz"));
		System.out.println("Abstract Factory PC Config:: " + pc);
		System.out.println("Abstract Factory Server Config:: " + server);
	}
	
}
