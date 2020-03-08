package com.singleton;

import java.util.*;

public class SingletonPersonTest {

	public static void main(String[] args) {

		System.out.println("*********************************************************");
		System.out.println("// SIMPLE POOL OBJECT BEGIN");
		System.out.println("=========================================================");

		System.out.println("*********************************************************");
		System.out.println("// Person fatih = Person.createPerson(500, \"Fatih\", \"NAR\");");
		System.out.println("// Person tuna = Person.createPerson(501, \"Tuna\", \"NAR\");");
		System.out.println("// Person durmus = Person.createPerson(502, \"Durmus\", \"NAR\");");
		System.out.println("// Person asya = Person.createPerson(503, \"Asya\", \"NAR\");");
		System.out.println("=========================================================");
		System.out.println("Output : ");
		Person fatih = Person.createPerson(500, "Fatih", "NAR");
		Person tuna = Person.createPerson(501, "Tuna", "NAR");
		Person durmus = Person.createPerson(502, "Durmus", "NAR");
		Person asya = Person.createPerson(503, "Asya", "NAR");

		System.out.println("*********************************************************");
		System.out.println("// System.out.println(Person.getPerson(500));");
		System.out.println("// System.out.println(Person.getPerson(501));");
		System.out.println("// System.out.println(Person.getPerson(502));");
		System.out.println("// System.out.println(Person.getPerson(503));");
		System.out.println("=========================================================");
		System.out.println("Output : ");
		System.out.println(Person.getPerson(500));
		System.out.println(Person.getPerson(501));
		System.out.println(Person.getPerson(502));
		System.out.println(Person.getPerson(503));

		System.out.println("*********************************************************");
		System.out.println("// System.out.println(fatih);");
		System.out.println("// System.out.println(tuna);");
		System.out.println("// System.out.println(durmus);");
		System.out.println("// System.out.println(asya);");
		System.out.println("=========================================================");
		System.out.println("Output : ");
		System.out.println(fatih);
		System.out.println(tuna);
		System.out.println(durmus);
		System.out.println(asya);

		System.out.println("*********************************************************");
		System.out.println("// Person.showPeople();");
		System.out.println("=========================================================");
		System.out.println("Output : ");
		Person.showPeople();

		System.out.println("*********************************************************");
		System.out.println("// SIMPLE POOL OBJECT END");
		System.out.println("=========================================================");

	}

}

class Person {
	final Integer identity;
	final String name;
	final String surname;

	private final static Map<Integer, Person> people = new HashMap<Integer, Person>();

	private Person(Integer identity, String name, String surname) {
		this.identity = identity;
		this.name = name;
		this.surname = surname;
	}

	static Person createPerson(Integer identity, String name, String surname) {
		Person person = people.get(identity);

		if (person == null) {
			person = new Person(identity, name, surname);
			people.put(identity, person);
		}

		return person;
	}

	static Person getPerson(Integer identity) {
		return people.get(identity);
	}

	static void showPeople() {
		for (Map.Entry<Integer, Person> person : people.entrySet()) {
			System.out.println(person);
		}
	}

	@Override
	public String toString() {
		return "(" + identity + ") " + name + " " + surname + " {" + super.toString() + "}";
	}
}