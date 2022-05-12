package com.test.employee.service;

import java.util.List;

import com.test.employee.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	
	//For Updating Employee's Records
	Employee getEmployeeById(long id);

}
