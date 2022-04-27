package org.spring.boot.app;

import org.spring.boot.app.test.Doctor;
import org.spring.boot.app.test.Nurse;
import org.spring.boot.app.test.Patient;
import org.spring.boot.app.test.Staff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringFreameworkApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringFreameworkApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		Staff staff = context.getBean(Doctor.class);
		staff.assist();
		
		Staff staff1 = context.getBean(Nurse.class);
		staff1.assist();
		
		Staff staff2 = context.getBean(Patient.class);
		staff2.assist();
		
	}

}
