package com.test.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
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
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//Saving New Employee Data into DataBase
		employeeService.saveEmployee(employee);
		
		//Redirecting to the HOME PAGE
		return "redirect:/";	
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
		
		// Getting Employee from the Service
		Employee employee = employeeService.getEmployeeById(id);
		
		// Setting Employee as a Model Attribute to Pre-Populate on the Form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// Calling Delete Employee Method 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
