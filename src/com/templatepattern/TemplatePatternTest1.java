package com.templatepattern;

public class TemplatePatternTest1 {

	public static void main(String[] args) {
		String connectionString = "server=192.168.0.7";
		String username = "learner";  
		String password = "designPatterns";
		StudentRegistration sr = new DatabaseBasedStudentRegistration(connectionString, username, password);
		System.out.println();
		
		Person p1 = new Person("Ali", "Ok");
		System.out.println("Registering " + p1);
		sr.register(p1);
		System.out.println();

		Person p2 = new Person("Muhammed", "Ustunerenler");
		System.out.println("Registering " + p2);
		sr.register(p2);
		System.out.println();
	}

}

abstract class StudentRegistration {
	
	// template method
	final Student register(Person person) {
		if (checkPerson(person)) {
			startOperation();
			try {
				int studentId = getNewIdentity(person);
				Student student = new Student(person, studentId);
				completeOperation();
				
				return student;
			}
			catch (Exception e) {
				cancelOperation();
				promptError(e.getMessage());
			}
			
		}
		else {
			promptError(person + " is not a valid citizen.");
		}

		return null;
	}
	
	abstract void startOperation();
	
	abstract void completeOperation();
	
	abstract void cancelOperation();
	
	abstract boolean checkPerson(Person person);
	
	abstract int getNewIdentity(Person person);
	
	abstract void promptError(String errorMessage); 
	
}

class DatabaseBasedStudentRegistration extends StudentRegistration {
	private final DatabaseConnection connection;
	
	DatabaseBasedStudentRegistration(String connectionString, String username, String password) {
		connection = new DatabaseConnection(connectionString, username, password);
	}
	
	@Override
	void startOperation() {
		connection.beginTransaction();
	}

	@Override
	void completeOperation() {
		connection.commitTransaction();
	}

	@Override
	void cancelOperation() {
		connection.rollbackTransaction();
	}

	@Override
	boolean checkPerson(Person person) {
		return (person.toString().length() > 10);
	}

	@Override
	int getNewIdentity(Person person) {
		return Math.abs(person.toString().hashCode()) % 100000000;
	}

	@Override
	void promptError(String errorMessage) {
		System.out.println(errorMessage);		
	}
}

class Person {
	final String name;
	final String surname;

	Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
}

class Student extends Person {
	final int studentId;
	
	Student(String name, String surname, int studentId) {
		super(name, surname);
		this.studentId = studentId;
		System.out.println(this + " is created");
	}
	
	Student(Person person, int studentId) {
		super(person.name, person.surname);
		this.studentId = studentId;
		System.out.println(this + " is created");
	}		
	
	@Override
	public String toString() {
		return super.toString() + ", ID = " + studentId;
	}	
}

class DatabaseConnection {
	
	DatabaseConnection(String connectionString, String username, String password) {
		System.out.println("Connect to database using " + connectionString + ", Username = " + username + ", Password = " + password);
	}
	
	void beginTransaction() {
		System.out.println("Begin Transaction");
	}

	void commitTransaction() {
		System.out.println("Commit Transaction");
	}

	void rollbackTransaction() {
		System.out.println("Rollback Transaction");
	}
}


// Videos:
// https://www.coursera.org/lecture/design-patterns/2-2-1-template-method-pattern-mXu6R
// https://www.youtube.com/watch?v=aR1B8MlwbRI

// Pizza example
// https://stacktips.com/tutorials/design-patterns/template-method-design-pattern-in-java

// Vehicle example
// http://www.thejavageek.com/2016/09/29/template-method-implementation/

// Placing an order example
// http://javainsimpleway.com/template-method-pattern/
// https://javapapers.com/design-patterns/template-method-design-pattern/

// House building example
// https://www.journaldev.com/1763/template-method-design-pattern-in-java
// https://howtodoinjava.com/design-patterns/behavioral/template-method-pattern/

// Java puzzle for the template method pattern (by the Gang of Four)
// https://martin-thoma.com/java-puzzle-9-template-method-pattern/

// Example Template Method pattern use in Java core libraries
// 1. All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.
// 2. All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.