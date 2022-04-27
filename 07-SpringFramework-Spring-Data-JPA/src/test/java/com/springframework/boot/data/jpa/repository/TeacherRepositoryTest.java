package com.springframework.boot.data.jpa.repository;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.boot.data.jpa.entity.Cource;
import com.springframework.boot.data.jpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Cource courceDBA = Cource.builder()
						   .title("DBA")
						   .credit(5)
						   .build();
		
		Cource courceJava = Cource.builder()
				   .title("Java")
				   .credit(7)
				   .build();

		List<Cource> list = new ArrayList<>();
		
		list.add(courceDBA);
		list.add(courceJava);
		
		
		Teacher teacher = Teacher.builder()
						  .firstName("Sara")
						  .lastName("Khan")
						  .cources(list)
						  .build();
	
		teacherRepository.save(teacher);
	}

}
