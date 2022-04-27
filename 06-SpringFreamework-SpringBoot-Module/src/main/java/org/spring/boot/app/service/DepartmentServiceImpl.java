package org.spring.boot.app.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.spring.boot.app.entity.Department;
import org.spring.boot.app.error.DepartmentNotFoundException;
import org.spring.boot.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getListOfDepartments() {

		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(long deptId) throws DepartmentNotFoundException {
		
//		return departmentRepository.findById(deptId).get();
		Optional<Department> department = departmentRepository.findById(deptId);
		
		if(!department.isPresent()) {
			
			throw new DepartmentNotFoundException("Department Not Available");
			
		}
		return department.get();
		
	}

	@Override
	public void deleteDeprtmentById(long deptId) {
		
		departmentRepository.deleteById(deptId);
		
	}

	@Override
	public Department updateDepartmentById(long deptId, Department department) {

		Department dept = departmentRepository.findById(deptId).get();
		
		
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		
		if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepository.save(dept);
		
	}

	@Override
	public Department fetchDepartmentByName(String deptName) {

		return departmentRepository.findByDepartmentName(deptName);
		
	}

	@Override
	public List<Department> fetchAllDepartments() {

		return departmentRepository.fetchAllDepartments();
	}


	
	
}
