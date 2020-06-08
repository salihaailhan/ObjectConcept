package com.observerpattern;

import java.util.*;

/*
The observer pattern is a software design pattern in which an object, called the subject, 
maintains a list of its dependents, called observers, and notifies them automatically of 
any state changes, usually by calling one of their methods.
*/

public class ObserverPatternTest {

	public static void main(String[] args) {
		NewsAgency newsAgency = new NewsAgency("Anadolu Agency");
		newsAgency.subscribe(new Subscriber("Fatih", "Nar"));
		newsAgency.subscribe(new Subscriber("Selim", "Nar"));
		newsAgency.subscribe(new Subscriber("Serap", "Nar"));
		newsAgency.subscribe(new Subscriber("Asya", "Nar"));
		newsAgency.subscribe(new Subscriber("Tuna", "Nar"));

		newsAgency.updateNewsContent("A Turkish Scientist win a nobel because he proved one of the 6 math challenge.");
	}

}

interface Subject {
	public void subscribe(Observer subscriber);

	public void unsubscribe(Observer subscriber);

	public void notifySubscribers();
}

interface Observer {
	public void update(String newsContent);
}

class NewsAgency implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private String newsContent; // A Turkish Scientist win a nobel because he proved one of the 6 math challenge.
	final String name; // Anadolu Agency

	NewsAgency(String name) {
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

class Person {
	final String name; // Fatih
	final String surname; // Nar

	Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}
}

class Subscriber extends Person implements Observer {

	Subscriber(String name, String surname) {
		super(name, surname);
	}

	@Override
	public void update(String newsContent) {
		System.out.println("I am " + this + ", I get this news: " + newsContent);
	}

}
