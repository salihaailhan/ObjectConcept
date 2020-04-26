package com.compositepattern;

public class CompositeTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*");
		System.out.println("* Department / SalesDepartment / FinancialDepartment / HeadDepartment");
		System.out.println("*");
		System.out.println("***********************************************");

		Department salesDepartment = new SalesDepartment(1, "Sales department");
		Department financialDepartment = new FinancialDepartment(2, "Financial department");

		HeadDepartment headDepartment = new HeadDepartment(3, "Head department");

		headDepartment.addDepartment(salesDepartment);
		headDepartment.addDepartment(financialDepartment);

		headDepartment.printDepartmentName();
		System.out.println();

		System.out.println("***********************************************");
		System.out.println("*");
		System.out.println("* IStructure / Housing / Room");
		System.out.println("*");
		System.out.println("***********************************************");

		Housing building = new Housing("123 Street");
		Housing floor1 = new Housing("123 Street - First Floor");
		int firstFloor = building.addStructure(floor1);

		Room washroom1m = new Room("1F Men's Washroom");
		Room washroom1w = new Room("1F Women's Washroom");
		Room common1 = new Room("1F Common Area");
		int firstMens = floor1.addStructure(washroom1m);
		int firstWomans = floor1.addStructure(washroom1w);
		int firstCommon = floor1.addStructure(common1);

		building.enter(); // enter the building
		Housing currentFloor = (Housing) building.getStructure(firstFloor);
		currentFloor.enter(); // walk into the first floor
		Room currentRoom = (Room) currentFloor.getStructure(firstMens);
		currentRoom.enter(); // walk into the men's room
		currentRoom = (Room) currentFloor.getStructure(firstCommon);
		currentRoom.enter(); // walk into the common area
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
