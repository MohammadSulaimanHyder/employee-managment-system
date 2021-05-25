package com.app.employee_managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.employee_managment.model.Employee;
import com.app.employee_managment.services.EmployeeServices;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("/")
	public String viewHome(Model model) {
		
		model.addAttribute("employeeList", employeeServices.fetchAllEmployees());
		return "home";
	}
	
	@GetMapping("/saveNewEmplyee")
	public String saveNewEmployee(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "save_New_Employee";
	}
	
	@PostMapping("/addNewEmplyee")
	public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeServices.addNewEmployee(employee);
		return "redirect:/"; //after saving details we will automatically redirect to home page.
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployeeDetails(@PathVariable(value = "id") Long id, Model model) {
		
		Employee employee = employeeServices.findEmployeeById(id);
		model.addAttribute("employee", employee);
		
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeDetails(@PathVariable(value = "id") Long id) {
		
		employeeServices.deleteEmployeeById(id);
		return "redirect:/";
	}
}
