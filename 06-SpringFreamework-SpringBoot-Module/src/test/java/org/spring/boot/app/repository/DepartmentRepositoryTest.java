package org.spring.boot.app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spring.boot.app.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.junit.Assert;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {

		Department department = Department.builder().
								departmentName("Mech").
								departmentAddress("Pune").
								departmentCode("A-4").build();

		entityManager.persist(department);

	}

	@Test
	public void whenFindById_thenReturnDepartment() {

		Department department = departmentRepository.findById(1L).get();

		Assert.assertEquals(department.getDepartmentName(), "Mech");

	}

}
