package com.app.employee_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.employee_managment.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
