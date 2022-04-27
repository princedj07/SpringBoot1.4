package org.spring.boot.app.test;

import org.springframework.stereotype.Component;

@Component
public class Doctor implements Staff {

	public void assist() {
		System.out.println("Doctor is Assisting");
	}
}
