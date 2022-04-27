package org.spring.boot.app.test;

import org.springframework.stereotype.Component;

@Component
public class Patient implements Staff{
		
	public void assist() {
		System.out.println("Patient visiting to Hospital...");		
	}
}
