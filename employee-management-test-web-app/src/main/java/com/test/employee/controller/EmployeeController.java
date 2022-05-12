package com.test.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.employee.model.Employee;
import com.test.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	//Injecting Service Class
	@Autowired
	private EmployeeService employeeService;
	
	//Display List of Employees
	//Creating method handler for HOME Page (index.html) to display list of employees
	
	@GetMapping("/")
	public String viewHomePage(Model model) {	
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//Create Model attribute to bind from Data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
}
