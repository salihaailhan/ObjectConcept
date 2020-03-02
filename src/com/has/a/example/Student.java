package com.has.a.example;

import java.util.*;

public class Student extends Person {
	public final String schoolName;
	private List<Book> myBooks = new ArrayList<Book>();
	
	Student(String name, String surname, String schoolName) {
		super(name, surname);
		this.schoolName = schoolName;
	}
	
	boolean doYouHaveThisBook(Book book) {
		return myBooks.contains(book);
	}
	
	void addBook(Book book) {
		myBooks.add(book);
	}
	
	void removeBook(Book book) {
		myBooks.remove(book);
	}
}
