package com.springframework.boot.data.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springframework.boot.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String firstName);
	
	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailId(String emailId);
	
	
	//Native Query
	@Query(value = "Select * from tbl_student s where s.first_name = ?1 ", nativeQuery = true)
	Student getStudentByName(String name);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
	int updateStudentByEmailId(String firstName, String email);
	
}
