package org.spring.boot.app.test;

public class Patient {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient(String name) {
		super();
		System.out.println("Param Constructor");
		this.name = name;
	}

	public Patient() {
		super();
		System.out.println("Super Constructor");
	}
	
	
	
}
