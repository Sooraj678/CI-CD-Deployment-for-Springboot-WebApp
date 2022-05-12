package com.test.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.test.employee.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	
	//For Updating Employee's Records
	Employee getEmployeeById(long id);
	
	//For Deleting Employee's Records
	void deleteEmployeeById(long id);
}
