package com.app.employee_managment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.employee_managment.model.Employee;
import com.app.employee_managment.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public void addNewEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		
		Employee employee = null;
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		if(result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Employee with id " + id + " not found.");
		}
		return employee;
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
