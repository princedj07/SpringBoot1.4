package org.spring.boot.app.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spring.boot.app.entity.Department;
import org.spring.boot.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class DepartmentServiceImplTest {

	@Autowired
	private DepartmentServiceImpl departmentServiceImplTest;
	
	@MockBean
	private DepartmentRepository departmentRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder().
								departmentName("IT").
								departmentAddress("Pune").
								departmentCode("CG-4").
								departmentId(1L).build();
		
		Mockito.when(departmentRepo.findByDepartmentName("IT")).thenReturn(department);
								
	}

	@Test
	@DisplayName("Get Data based on Valid Department Name")
//	@Disabled
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		
		String deptName = "IT";
		
		Department found = departmentServiceImplTest.fetchDepartmentByName(deptName);
		
		Assert.assertEquals(deptName, found.getDepartmentName());
		
	}

}
