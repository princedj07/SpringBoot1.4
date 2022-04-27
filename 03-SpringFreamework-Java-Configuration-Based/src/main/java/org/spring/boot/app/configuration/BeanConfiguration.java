package org.spring.boot.app.configuration;

import org.spring.boot.app.test.Doctor;
import org.spring.boot.app.test.Nurse;
import org.spring.boot.app.test.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.spring.boot.app.*")
public class BeanConfiguration {

	@Bean
	public Doctor getDoctor() {
		return new Doctor();
	}

	@Bean
	public Nurse getNurse() {
		return new Nurse();
	}
	
	@Bean
	public Patient getPatient() {
		return new Patient();
	}
	
}
