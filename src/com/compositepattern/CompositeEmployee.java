package com.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeEmployee {

	public static void main(String[] args) {
		Manager hasanGurbuz = new Manager("Hasan", "Gurbuz", 1);
		Manager salihaHur = new Manager("Saliha","Hur", 2);
		hasanGurbuz.addSubordinate(salihaHur);
		hasanGurbuz.addSubordinate(new Employee("Fatih", "Ak", 3));
		hasanGurbuz.addSubordinate(new Employee("Murat", "Kek", 4));
		hasanGurbuz.addSubordinate(new Employee("Zafer", "Kok", 5));
		hasanGurbuz.addSubordinate(new Employee("Ayse", "Kac", 6));
		salihaHur.addSubordinate(new Employee("Arzu", "Basar", 7));
		salihaHur.addSubordinate(new Employee("Muge", "Enes", 8));
		Manager yusufEdman = new Manager("Yusuf","Edman", 9);
		salihaHur.addSubordinate(yusufEdman);
		yusufEdman.addSubordinate(new Employee("Ali", "Ustuner", 10));
		yusufEdman.addSubordinate(new Employee("Veli", "Erener", 11));
		yusufEdman.addSubordinate(new Employee("Kerem", "Er", 12));
		
		hasanGurbuz.sendMessage("Learn Object Oriented Programming & Design Patterns");

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

class Employee extends Person {
	public final int employeeId;
	
	Employee(String name, String surname, int employeeId) {
		super(name, surname);
		this.employeeId = employeeId;
	}
	
	@Override
	void sendMessage(String message) {
		System.out.println("I am " + name + " " + surname + ", I will do the job: " + message);
	}
}

class Manager extends Employee {
	private final List<Employee> subordinates = new ArrayList<Employee>(); 
	
	Manager(String name, String surname, int employeeId) {
		super(name, surname, employeeId);
	}
	
	Employee addSubordinate(Employee subordinate) {
		subordinates.add(subordinate);
		return subordinate;
	}
	
	void removeSubordinated(int employeeId) {
		for (Employee employee : subordinates) {
			if (employee.employeeId == employeeId) {
				subordinates.remove(employee);
				return;
			}
		}
	}
	
	Employee getSubordinate(int employeeId) {
		for (Employee employee : subordinates) {
			if (employee.employeeId == employeeId) {
				return employee;
			}
		}		
		return null;
	}
	
	@Override
	void sendMessage(String message) {
		System.out.println("I am " + name + " " + surname + ", I will order the job: " + message + " to my subordinates");
		
		for (Employee employee : subordinates) {
			employee.sendMessage(message);
		}
	}	

}