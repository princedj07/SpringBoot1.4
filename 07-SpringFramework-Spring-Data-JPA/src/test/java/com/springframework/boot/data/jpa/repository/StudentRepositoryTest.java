package com.springframework.boot.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.boot.data.jpa.entity.Guardian;
import com.springframework.boot.data.jpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
	public void saveStudent() {
		Student student = Student.builder()
						  .emailId("princedj@gmail.com")
						  .firstName("Prince")
						  .lastName("DJ")
//						  .guardianName("RunVijay")
//						  .gaurdianEmail("runvijay@gmail.com")
//						  .guardianMobile("9786789656")
						  .build();
		
		studentRepository.save(student);
	}
	
//	@Test
	public void getAllStudents() {
		
		List<Student> list = studentRepository.findAll();
		
		System.out.println("All Students : "+list);
	}
	
//	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
							.name("Run")
							.email("abcd@gmail.com")
							.mobile("7896547896")
							.build();
		
		Student student = Student.builder()
						  .firstName("Prince")
						  .lastName("DJ")
						  .emailId("prince@gmail.com")
						  .guardian(guardian)
						  .build();
		
		studentRepository.save(student);
		
	} 

//	@Test
	public void getStudentByName() {
		
		List<Student> list = studentRepository.findByFirstName("Prince");
		System.out.println("List Of Students : "+list);
	}
	
//	@Test
	public void getStudentByEmailId() {
		
		Student emailId = studentRepository.getStudentByEmailId("prince@gmail.com");
		System.out.println("EmialID : "+emailId);
		
	}
	
//	@Test
	public void getStudentDataByName() {
		
			Student studentByName = studentRepository.getStudentByName("Prince");
			System.out.println("Student By Name : "+studentByName);
	}
	
	@Test
	public void updateStudentByEmailId() {
		
			int studentByName = studentRepository.updateStudentByEmailId("Sarang", "prince@gmail.com");
			System.out.println("updateStudentByEmailId : "+studentByName);
	}
}
