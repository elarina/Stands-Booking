package com.advalange.model;

public class Employee {
	private final String name;
	private final String lastname;
	
	public Employee(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}
	
	
}
