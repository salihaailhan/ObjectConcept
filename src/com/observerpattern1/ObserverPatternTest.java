package com.observerpattern1;

import java.util.*;


/*
The observer pattern is a software design pattern in which an object, called the subject, 
maintains a list of its dependents, called observers, and notifies them automatically of 
any state changes, usually by calling one of their methods.
*/

public class ObserverPatternTest {

	public static void main(String[] args) {


		PrincipalIntelligenceAgency principalIntelligenceAgency = new PrincipalIntelligenceAgency("Anadolu Agency");
		principalIntelligenceAgency.subscribe(new BranchIntelligenceAgency("Fatih", "Nar"));
		principalIntelligenceAgency.subscribe(new BranchIntelligenceAgency("Selim", "Nar"));
		principalIntelligenceAgency.subscribe(new BranchIntelligenceAgency("Serap", "Nar"));
		principalIntelligenceAgency.subscribe(new BranchIntelligenceAgency("Asya", "Nar"));
		principalIntelligenceAgency.subscribe(new BranchIntelligenceAgency("Tuna", "Nar"));

		principalIntelligenceAgency
				.updateNewsContent("A Turkish Scientist win a nobel because he proved one of the 6 math challenge.");


		// Composite Pattern
		System.out.println();
		PrincipalIntelligenceAgency1 principalIntelligenceAgency1 = new PrincipalIntelligenceAgency1("Design Pattern", "Agency");
		principalIntelligenceAgency1.addSubordinate(new BranchIntelligenceAgency1("Gürkay", "BAŞYİĞİT"));
		principalIntelligenceAgency1.addSubordinate(new BranchIntelligenceAgency1("Haydar", "DUZ"));
		principalIntelligenceAgency1.addSubordinate(new BranchIntelligenceAgency1("Nurdolla", "CESUR"));

		principalIntelligenceAgency1.sendMessage("A Turkish Scientist win a nobel because he proved one of the 6 math challenge.");

	}

}

interface Agency {
	public void subscribe(Observer subscriber);

	public void unsubscribe(Observer subscriber);

	public void notifySubscribers();
}

interface Observer {
	public void update(String newsContent);
}

class PrincipalIntelligenceAgency implements Agency {
	private List<Observer> observers = new ArrayList<Observer>();
	private String newsContent;
	final String name;

	PrincipalIntelligenceAgency(String name) {
		this.name = name;
	}

	@Override
	public void subscribe(Observer subscriber) {
		observers.add(subscriber);
	}

	@Override
	public void unsubscribe(Observer subscriber) {
		observers.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		System.out.println(this + " is sending news to subscribers: " + newsContent);

		for (Observer subscriber : observers) {
			subscriber.update(newsContent);
		}
	}

	void updateNewsContent(String newsContent) {
		this.newsContent = newsContent;

		notifySubscribers();
	}

	@Override
	public String toString() {
		return name;
	}
}

class Agent {
	final String name;
	final String surname;

	Agent(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}
}

class BranchIntelligenceAgency extends Agent implements Observer {

	BranchIntelligenceAgency(String name, String surname) {
		super(name, surname);
	}

	@Override
	public void update(String newsContent) {
		System.out.println("I am " + this + ", I get this news: " + newsContent);
	}

}

abstract class Person {
	public final String name;
	public final String surname;

	Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	abstract void sendMessage(String message);
}

class BranchIntelligenceAgency1 extends Person {

	BranchIntelligenceAgency1(String name, String surname) {
		super(name, surname);
	}

	@Override
	void sendMessage(String message) {
		System.out.println("I am " + name + " " + surname + ", I get this news: " + message);
	}
}

class PrincipalIntelligenceAgency1 extends BranchIntelligenceAgency1  {
	
	private final List<BranchIntelligenceAgency1> subordinates = new ArrayList<BranchIntelligenceAgency1>();

	PrincipalIntelligenceAgency1(String name, String surname) {
		super(name, surname);
	}

	BranchIntelligenceAgency1 addSubordinate(BranchIntelligenceAgency1 subordinate) {
		subordinates.add(subordinate);
		return subordinate;
	}

	@Override
	void sendMessage(String message) {
		System.out.println(name + surname + " is sending news to subscribers: " + message);
		for (BranchIntelligenceAgency1 branchIntelligenceAgency1 : subordinates) {
			branchIntelligenceAgency1.sendMessage(message);
		}
	}

}
