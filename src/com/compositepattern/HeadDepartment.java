package com.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {
	
	private int id;
	private String name;
	private List<Department> childDepartments;
	
	public HeadDepartment(int id, String name) {
		this.id = id;
		this.name = name;
		this.childDepartments = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printDepartmentName() {
		childDepartments.forEach(Department::printDepartmentName);
	}
	
	public void addDepartment(Department department) {
		childDepartments.add(department);
	}
	
	public void removeDepartment(Department department) {
		childDepartments.remove(department);
	}
}
