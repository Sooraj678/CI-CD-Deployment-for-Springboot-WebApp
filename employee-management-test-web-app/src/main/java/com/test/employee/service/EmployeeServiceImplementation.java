package com.test.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.employee.model.Employee;
import com.test.employee.repository.EmployeeRepository;

public class EmployeeServiceImplementation implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
		
	}

}
