package com.homework3;

import com.factorymethod.CircleFactoryMethod;
import com.factorymethod.RectangleFactoryMethod;
import com.factorymethod.ShapeFactoryMethod;
import com.factorymethod.SquareFactoryMethod;

public class ImprovedFactoryMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	// traditional Factory Method is not type-safe
	static void traditionalFactoryMethod() {
		System.out.println("Traditional Factory Method");
		System.out.println("--------------------------");
		
		TraditionalPlanFactory factory = new TraditionalPlanFactory();
		Plan plan1 = factory.getPlan("DEMESTICPLAN");
		Plan plan2 = factory.getPlan("COMMERCIALPLAN");
		Plan plan3 = factory.getPlan("INSTITUTIONALPLAN");
		Plan plan4 = factory.getPlan("DEMESTICPLAN");
		
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
 * Gurkay Improved Plan Factory
 ******************************************************/
abstract class AbsImprovedPlanFactory {
	
	abstract double get();
	
	final public void calculateBill(int units) {
		System.out.println("Bill using " + getClass().getName() + " = " + units + get());
	}
}

class ImprovedPlanFactory {

	public AbsImprovedPlanFactory getPlan(String planType) {
		if(planType != null) {
			switch(planType.toUpperCase()) {
			case "DOMESTICPLAN": return new DomesticPlan();
			case "COMMERCIALPLAN": return new CommercialPlan();
			case "INSTITUTIONALPLAN": return new InstitutionalPlan();
			}
		}
		return null;
	}
}

class DomesticPlan extends AbsImprovedPlanFactory {

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 3.50;
	}
}

class CommercialPlan extends AbsImprovedPlanFactory {
	
	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 7.50;
	}
}

class InstitutionalPlan extends AbsImprovedPlanFactory {
	
	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 5.50;
	}
}


/******************************************************
 * Traditional Plan Factory
 ******************************************************/
abstract class Plan {
	abstract double getRate();
	
	final public void calculateBill(int units) {
		System.out.println("Bill using " + getClass().getName() + " = " + units + getRate());
	}
}

class TraditionalPlanFactory {
	public Plan getPlan(String planType) {
		if(planType != null) {
			switch(planType.toUpperCase()) {
			case "DOMESTICPLAN": return new DomesticPlan();
			case "COMMERCIALPLAN": return new CommercialPlan();
			case "INSTITUTIONALPLAN": return new InstitutionalPlan();
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