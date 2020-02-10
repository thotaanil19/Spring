package com.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.domain.Employee;
import com.springboot.jpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return employeeService.findEmployeeById(id);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);

	}

	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		employeeService.delete(id);
		return true;
	}

	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
}
