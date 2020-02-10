package com.anil.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.springbootdemo.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@PostMapping
	public Employee saveEmp (@RequestBody Employee emp) {
		System.out.println(emp);
		return emp;
	}

	@GetMapping
	public Employee saveEmp () {
		Employee emp = new Employee();
		emp.setName("Anil");
		emp.setIsActive(true);
		return emp;
	}


}
