package org.spring.boot.app;

import org.spring.boot.app.configuration.BeanConfiguration;
import org.spring.boot.app.test.Doctor;
import org.spring.boot.app.test.Nurse;
import org.spring.boot.app.test.Patient;
import org.spring.boot.app.test.Staff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringFreameworkApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringFreameworkApplication.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		
		Doctor doctor = context.getBean(Doctor.class);
		doctor.assist();
		doctor.setQualification("MBBS");
		System.out.println(doctor);
		
		Doctor doctor2 = context.getBean(Doctor.class);
		System.out.println(doctor2);
		
		System.out.println("*******************************");
		
		Nurse nurse = context.getBean(Nurse.class);
		nurse.assist();
		nurse.setName("Kajal");
		System.out.println(nurse);
		
		Nurse nurse2 = context.getBean(Nurse.class);
		System.out.println(nurse2);
		
	}

}
