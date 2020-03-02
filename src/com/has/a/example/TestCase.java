package com.has.a.example;

import java.util.*;

public class TestCase {

	
	static Restaurant restaurant = new Restaurant();

	public static void main(String[] args) {
		Student student = new Student("Gürkay", "Nar", "AYBU");
		student.eat(restaurant);
		
		Kitchen kitchen = new Kitchen();
		student.eat(kitchen);
		
		System.out.println("Student ID Card: " + student.identityCard.getIdentityNumber());
		Book book1 = new Book("Design Patterns", "Textbook");
		Book book2 = new Book("Lord of the Rings", "Fantastic");
		Book book3 = new Book("Dune", "Science Fiction");
		
		student.addBook(book1);
		student.addBook(book2);
		student.addBook(book3);
		System.out.println("You have book1("+ book1.name +") : " + student.doYouHaveThisBook(book1));
		System.out.println("You have book2("+ book2.name +") : " + student.doYouHaveThisBook(book2));
		System.out.println("You have book3("+ book3.name +") : " + student.doYouHaveThisBook(book3));
		student.removeBook(book1);
		student.removeBook(book2);
		student.removeBook(book3);
		System.out.println("You have book1 : " + student.doYouHaveThisBook(book1));
		System.out.println("You have book2 : " + student.doYouHaveThisBook(book2));
		System.out.println("You have book3 : " + student.doYouHaveThisBook(book3));
	}

	/*
	 * public class IdentityCard { static private long identityCounter = 0; private
	 * long identityNo;
	 * 
	 * IdentityCard() { identityCounter++; identityNo = identityCounter; }
	 * 
	 * public long getIdentityNumber() { return identityNo; } }
	 * 
	 * public abstract class FoodPlace { abstract void eat(String foodName); }
	 * 
	 * public class Restaurant extends FoodPlace {
	 * 
	 * @Override void eat(String foodName) { System.out.println("You eat " +
	 * foodName + ", was it delicious? You need to pay 10 TL."); } }
	 * 
	 * public class Kitchen extends FoodPlace {
	 * 
	 * @Override void eat(String foodName) { System.out.println(foodName +
	 * " was good, now I need to clean the kitchen."); } }
	 * 
	 * public abstract class Person { public final String name; public final String
	 * surname; public final IdentityCard identityCard = new IdentityCard();
	 * 
	 * Person(String name, String surname) { this.name = name; this.surname =
	 * surname; }
	 * 
	 * public String getFullName() { return name + " " + surname; }
	 * 
	 * public void eat(FoodPlace foodPlace) { foodPlace.eat("Menemen"); } }
	 * 
	 * public class Book { public final String name; public final String gender;
	 * 
	 * Book(String name, String gender) { this.name = name; this.gender = gender; }
	 * }
	 * 
	 * public class Student extends Person { public final String schoolName; private
	 * List<Book> myBooks = new ArrayList<Book>();
	 * 
	 * Student(String name, String surname, String schoolName) { super(name,
	 * surname); this.schoolName = schoolName; }
	 * 
	 * boolean doYouHaveThisBook(Book book) { return myBooks.contains(book); }
	 * 
	 * void addBook(Book book) { myBooks.add(book); }
	 * 
	 * void removeBook(Book book) { myBooks.remove(book); } }
	 */
}
