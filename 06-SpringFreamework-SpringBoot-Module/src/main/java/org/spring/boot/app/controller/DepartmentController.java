package org.spring.boot.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.app.entity.Department;
import org.spring.boot.app.error.DepartmentNotFoundException;
import org.spring.boot.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		LOGGER.info("Inside saveDepartment");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/deptList")
	public List<Department> getListOfDepartments(){
		
		LOGGER.info("Inside getListOfDepartments");
		return departmentService.getListOfDepartments();
	}
	
	@GetMapping("/deptList/{id}")
	public Department getDepartmentById(@PathVariable("id") long deptId) throws DepartmentNotFoundException {
		
		return departmentService.getDepartmentById(deptId);
	}
	
	@DeleteMapping("/deptList/{id}")
	public String deleteDeprtmentById(@PathVariable("id") long deptId) {
		
		departmentService.deleteDeprtmentById(deptId);
		
		return "Department Deleted Successfully for id : "+deptId;
	}
	
	@PutMapping("/deptList/{id}")
	public Department updateDepartmentById(@PathVariable("id") long deptId, @RequestBody Department department) {
		
		return departmentService.updateDepartmentById(deptId, department);
	}
	
	@GetMapping("/deptList/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName) {
		
		return departmentService.fetchDepartmentByName(deptName);
	}
	
	@GetMapping("/deptartmentList")
	public List<Department> fetchAllDepartments(){
		
		return departmentService.fetchAllDepartments();
	}
}
