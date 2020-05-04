package com.homework3;


/*In this homework you will improve the traditional Factory Method. Factory Method 
 * gets an string input and returns an object based on the value of that string. Developer 
 * can easily send wrong string and he or she will not see problem in compile-time (an error 
 * will be occurred in run-time). In this homework you will develop type-safe version of Factory 
 * Method, namely improved Factory Method.

Change below code and create your own ImprovedPlanFactory  (you will change the code in 
the line with '// student code ...').

ImprovedFactoryMethodTest.java

Expected output is:

Traditional Factory Method
--------------------------
Bill using DomesticPlan = 35.0
Bill using CommercialPlan = 75.0
Bill using InstitutionalPlan = 55.0
Error occured with plan4! There is no such a thing as DOMESTOCPLAN


Improved Factory Method
-----------------------
Bill using DomesticPlan = 35.0
Bill using CommercialPlan = 75.0
Bill using InstitutionalPlan = 55.0

You will work alone. Note that, the code you will add is no more than 20 lines of code, 
this is an easy homework for you.
*/

public class Homework3Solution {

	public static void main(String[] args) {
		traditionalFactoryMethod();

		System.out.println();
		System.out.println();
		
		improvedFactoryMethod();
	}

	// traditional Factory Method is not type-safe
	static void traditionalFactoryMethod() {
		System.out.println("Traditional Factory Method");
		System.out.println("--------------------------");
		
		TraditionalPlanFactory factory = new TraditionalPlanFactory();
		Plan plan1 = factory.getPlan("DOMESTICPLAN");
		Plan plan2 = factory.getPlan("COMMERCIALPLAN");
		Plan plan3 = factory.getPlan("INSTITUTIONALPLAN");
		Plan plan4 = factory.getPlan("DOMESTOCPLAN");
		
		try {
			int units = 10;
			plan1.calculateBill(units);
			plan2.calculateBill(units);
			plan3.calculateBill(units);
			System.out.println(plan4);
			plan4.calculateBill(units);
		}
		catch(Exception e) {
			System.out.println("Error occured with plan4! There is no such a thing as DOMESTOCPLAN");
		}
	}
	
	// improved Factory Method is type-safe
	static void improvedFactoryMethod() {
		System.out.println("Improved Factory Method");
		System.out.println("-----------------------");

		int units = 10;

		Plan plan1a = ImprovedPlanFactory.DomesticPlan.get();
		Plan plan2a = ImprovedPlanFactory.CommercialPlan.get();
		Plan plan3a = ImprovedPlanFactory.InstitutionalPlan.get();
		plan1a.calculateBill(units);
		plan2a.calculateBill(units);
		plan3a.calculateBill(units);
		
		System.out.println();
		
		// or equivalently
		Plan plan1b = ImprovedPlanFactory.get(ImprovedPlanFactory.DomesticPlan);
		Plan plan2b = ImprovedPlanFactory.get(ImprovedPlanFactory.CommercialPlan);
		Plan plan3b = ImprovedPlanFactory.get(ImprovedPlanFactory.InstitutionalPlan);	
		plan1b.calculateBill(units);
		plan2b.calculateBill(units);
		plan3b.calculateBill(units);

		System.out.println();
		
		// or equivalently
		Plan plan1c = ImprovedPlanFactory.get("DomesticPlan");
		Plan plan2c = ImprovedPlanFactory.get("CommercialPlan");
		Plan plan3c = ImprovedPlanFactory.get("InstitutionalPlan");	
		Plan plan4c = ImprovedPlanFactory.get("DomestocPlan");
		
		try {
			plan1c.calculateBill(units);
			plan2c.calculateBill(units);
			plan3c.calculateBill(units);
			System.out.println(plan4c);
			plan4c.calculateBill(units);
		}
		catch(Exception e) {
			System.out.println("Error occured with plan4! There is no such a thing as DomestocPlan");
		}		
	}	
}


// Improved Plan Factory
enum ImprovedPlanFactory {
	DomesticPlan, 
	CommercialPlan, 
	InstitutionalPlan;
	
	// expected in homework
	// get by enum value (type-safe, compile-time checked)
	Plan get() {
		switch (this) {
		case DomesticPlan: return new DomesticPlan(); 
		case CommercialPlan: return new CommercialPlan(); 
		case InstitutionalPlan: return new InstitutionalPlan();
		}
		
		return null;
	}
	
	// extra to homework
	// get by enum value parameter (type-safe, compile-time checked)
	static Plan get(ImprovedPlanFactory type) {
		return (type == null ? null : type.get());
	}
	
	// extra to homework
	// get by string name (not type-safe, run-time checked)
	static Plan get(String type) {
		try {
			ImprovedPlanFactory planFactory = ImprovedPlanFactory.valueOf(type);
			
			return get(planFactory);
		}
		catch(Exception e) {
		}
		
		return null;		
	}	
}


// Traditional Plan Factory
class TraditionalPlanFactory {
	public Plan getPlan(String planType) {
		if (planType != null) {
			switch (planType.toUpperCase()) {
			case "DOMESTICPLAN": return new DomesticPlan(); 
			case "COMMERCIALPLAN": return new CommercialPlan(); 
			case "INSTITUTIONALPLAN": return new InstitutionalPlan();
			}
		}
		
		return null;
	}
}

abstract class Plan {
	abstract double getRate();

	final public void calculateBill(int units) {
		System.out.println("Bill using " + getClass().getName() + " = " + units * getRate());
	}
}

class DomesticPlan extends Plan {
	@Override
	public double getRate() {
		return 3.50;
	}
}

class CommercialPlan extends Plan {
	@Override
	public double getRate() {
		return 7.50;
	}
}

class InstitutionalPlan extends Plan {
	@Override
	public double getRate() {
		return 5.50;
	}
}