package org.spring.boot.app.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spring.boot.app.entity.Department;
import org.spring.boot.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder().departmentAddress("Mumbai").departmentName("IT").departmentId(1L)
				.departmentCode("CP-1").build();

	}

	@Test
	@Disabled
	void testSaveDepartment() throws Exception {
		Department inputDept = Department.builder().departmentAddress("Mumbai").departmentName("IT")
				.departmentCode("CP-1").build();

		Mockito.when(departmentService.saveDepartment(inputDept)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content("  {\r\n" + "        \"departmentName\": \"IT\",\r\n"
						+ "        \"departmentAddress\": \"Mumbai\",\r\n" + "        \"departmentCode\": \"CP-1\"\r\n"
						+ "    }"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	@DisplayName("Department Fetched By Id")
	void testGetDepartmentById() throws Exception {

		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.get("/deptList/1").
					contentType(MediaType.APPLICATION_JSON)).
					andExpect(status().isOk());
					
					
					
//					andExpect((jsonPath("$.departmentName").value(department.getDepartmentName())));
		
	}

}
