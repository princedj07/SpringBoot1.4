package org.spring.boot.app.repository;

import java.util.List;

import org.spring.boot.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentName(String deptName);

	@Query(value = "SELECT * FROM DEPARTMENT", nativeQuery = true)
	List<Department> fetchAllDepartments();

}
