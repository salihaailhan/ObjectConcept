package com.homework3;

public class ImprovedFactoryMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			plan4.calculateBill(units);
		} catch (Exception e) {
			System.out.println("Error occured with plan4! There is no such a thing as DEMESTICPLAN");
		}
	}

	// improved Factory Method is type-safe
	static void improvedFactoryMethod() {
		System.out.println("Improved Factory Method");
		System.out.println("-----------------------");

		Plan plan1 = ImprovedPlanFactory.DomesticPlan.get();
		Plan plan2 = ImprovedPlanFactory.CommercialPlan.get();
		Plan plan3 = ImprovedPlanFactory.InstitutionalPlan.get();

		int units = 10;
		plan1.calculateBill(units);
		plan2.calculateBill(units);
		plan3.calculateBill(units);

	}
}

/******************************************************
 * 14050162001 Gurkay BASYIGIT Improved Plan Factory
 ******************************************************/
interface InterfaceFactory{
	public Plan get();
}

enum ImprovedPlanFactory implements InterfaceFactory {
	
	DomesticPlan {
		@Override
		public Plan get() {
			// TODO Auto-generated method stub
			return new DomesticPlan();
		}	
	}, 
	
	CommercialPlan {
		@Override
		public Plan get() {
			// TODO Auto-generated method stub
			return new CommercialPlan();
		}	
	}, 
	InstitutionalPlan {
		@Override
		public Plan get() {
			// TODO Auto-generated method stub
			return new InstitutionalPlan();
		}		
	};
}

/*
 * class ImprovedPlanFactory extends TraditionalPlanFactory {
 * 
 * 
 * 
 * static class DomesticPlan extends Plan {
 * 
 * public static Plan get() {
 * 
 * return new DomesticPlan(); }
 * 
 * @Override public double getRate() { return 3.50; }
 * 
 * }
 * 
 * static class CommercialPlan extends Plan {
 * 
 * public static Plan get() {
 * 
 * return new CommercialPlan(); }
 * 
 * @Override public double getRate() { return 7.50; }
 * 
 * }
 * 
 * static class InstitutionalPlan extends Plan {
 * 
 * public static Plan get() {
 * 
 * return new InstitutionalPlan(); }
 * 
 * @Override public double getRate() { return 5.50; }
 * 
 * }
 * 
 * }
 */


/******************************************************
 * Traditional Plan Factory
 ******************************************************/
abstract class Plan {

	abstract double getRate();

	final public void calculateBill(int units) {
		System.out.println("Bill using " + getClass().getName() + " = " + units * getRate());
	}
}

class TraditionalPlanFactory {

	public Plan getPlan(String planType) {

		if (planType != null) {
			switch (planType.toUpperCase()) {
			case "DOMESTICPLAN":
				return new DomesticPlan();
			case "COMMERCIALPLAN":
				return new CommercialPlan();
			case "INSTITUTIONALPLAN":
				return new InstitutionalPlan();
			}
		}
		return null;
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