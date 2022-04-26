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
		
		
		Doctor doctor = context.getBean(Doctor.class);
		doctor.assist();
		System.out.println(doctor.getQualification());
		System.out.println(doctor.getNurse());
		
		Nurse nurse = (Nurse) context.getBean("nurseObj");
		nurse.assist();
		
		System.out.println("**************************");
		
		Staff staff = (Staff) context.getBean(Doctor.class);
		staff.assist();
		
		Staff staff2 = (Staff) context.getBean(Nurse.class);
		staff2.assist();
		
		System.out.println("**************************");
		
		Patient patient = context.getBean(Patient.class);
		System.out.println(patient.getName());
		
	}

}
