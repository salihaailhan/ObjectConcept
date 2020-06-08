package com.chainpattern;

public class TestCalcChain {

	public static void main(String[] args) {
		// Here I define all of the objects in the chain

		Chain chainCalc1 = new AddNumbers();
		Chain chainCalc2 = new SubtractNumbers();
		Chain chainCalc3 = new MultNumbers();
		Chain chainCalc4 = new DivideNumbers();

		// Here I tell each object where to forward the
		// data if it can't process the request

		chainCalc1.setNextChain(chainCalc2);
		chainCalc2.setNextChain(chainCalc3);
		chainCalc3.setNextChain(chainCalc4);

		// Define the data in the Numbers Object
		// and send it to the first Object in the chain

		Numbers request1 = new Numbers(4, 2, "add");
		Numbers request2 = new Numbers(4, 2, "sub");
		Numbers request3 = new Numbers(4, 2, "mult");
		Numbers request4 = new Numbers(4, 2, "div");
		Numbers request5 = new Numbers(4, 2, "blabla");

		chainCalc1.calculate(request1);
		System.out.println();
		chainCalc1.calculate(request2);
		System.out.println();
		chainCalc1.calculate(request3);
		System.out.println();
		chainCalc1.calculate(request4);
		System.out.println();
		chainCalc1.calculate(request5);
	}
}

abstract class Chain {

	abstract void setNextChain(Chain nextChain);

	abstract void calculate(Numbers request);

}

class Numbers {

	private int number1;
	private int number2;

	private String calculationWanted;

	public Numbers(int newNumber1, int newNumber2, String calcWanted) {

		number1 = newNumber1;
		number2 = newNumber2;
		calculationWanted = calcWanted;

	}

	public int getNumber1() {
		return number1;
	}

	public int getNumber2() {
		return number2;
	}

	public String getCalcWanted() {
		return calculationWanted;
	}
}

class AddNumbers extends Chain {

	private Chain nextInChain;

	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "add") {

			System.out.print(request.getNumber1() + " + " + request.getNumber2() + " = " + (request.getNumber1() + request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}
	}
}

class SubtractNumbers extends Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "sub") {

			System.out.print(request.getNumber1() + " - " + request.getNumber2() + " = " + (request.getNumber1() - request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}
	}
}

class MultNumbers extends Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "mult") {

			System.out.print(request.getNumber1() + " * " + request.getNumber2() + " = " + (request.getNumber1() * request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}
	}
}

class DivideNumbers extends Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "div") {

			System.out.print(request.getNumber1() + " / " + request.getNumber2() + " = " + (request.getNumber1() / request.getNumber2()));

		} else {

			System.out.print("Only works for add, sub, mult, and div");

		}
	}
}
