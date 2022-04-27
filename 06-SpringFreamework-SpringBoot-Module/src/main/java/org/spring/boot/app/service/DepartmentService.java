package org.spring.boot.app.service;

import java.util.List;

import org.spring.boot.app.entity.Department;
import org.spring.boot.app.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getListOfDepartments();

	Department getDepartmentById(long deptId) throws DepartmentNotFoundException;

	void deleteDeprtmentById(long deptId);

	Department updateDepartmentById(long deptId, Department department);

	Department fetchDepartmentByName(String deptName);

	List<Department> fetchAllDepartments();


}
