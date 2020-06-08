package com.homework9;

import java.util.*;

public class PrimeNumberIteratorTest {

	public static void main(String[] args) {

		// first iteration
		System.out.println("First iteration");
		System.out.println("---------------");
		long startTime = System.nanoTime();
		PrimeNumbers primeNumbers = new PrimeNumbers(1000);
		for (Long primeNumber : primeNumbers) {
			System.out.println(primeNumber);
		}
		/*
		 * Iterator<Long> iter = primeNumbers.iterator(); 
		 * while (iter.hasNext()) {
		 * 		System.out.println(iter.next()); 
		 * }
		 */
		long elapsedTime1 = System.nanoTime() - startTime;
		System.out.println();

		// second iteration
		System.out.println("Second iteration");
		System.out.println("----------------");
		startTime = System.nanoTime();
		for (Long primeNumber : primeNumbers) {
			System.out.println(primeNumber);
		}
		long elapsedTime2 = System.nanoTime() - startTime;
		System.out.println();

		// show execution time of first and second iteration
		System.out.println("Execution time for the first iteration  = " + (elapsedTime1 / 1000000000.0) + " seconds");
		System.out.println("Execution time for the second iteration = " + (elapsedTime2 / 1000000000.0) + " seconds");
	}
}

class PrimeNumbers implements Iterable<Long> {
	// student code
	private Long firstNumber = (long) 1;
	final Long lastNumber;

	PrimeNumbers(int lastNumber) {
		this.lastNumber = (long) lastNumber;
	}

	boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	@Override
	public Iterator<Long> iterator() {
		return new NumbersIterator();
	}

	class NumbersIterator implements Iterator<Long> {
		@Override
		public Long next() {

			Long number = firstNumber;
			firstNumber++;
			return number;

		}

		@Override
		public boolean hasNext() {
			
			if(!isPrime(firstNumber.intValue())) {
				firstNumber++;
			}
			
			if (firstNumber <= lastNumber) {
				return true;
			} else {
				firstNumber = (long) 1;
			}
			return false;
		}
	}

}
