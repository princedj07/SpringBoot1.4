package org.spring.boot.app.test;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Nurse implements Staff, BeanNameAware {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void assist() {
		System.out.println("Nurse giving Injection...");
	}

	@Override
	public String toString() {
		return "Nurse [name=" + name + "]";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Nurse.setBeanName() is called");
	}
	
	
}
