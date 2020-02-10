package com.springboot.rediscachedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rediscachedemo.dto.Employee;
import com.springboot.rediscachedemo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee getById(@PathVariable Integer id) {
		return employeeService.getById(id);
	}

	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		employeeService.deleteById(id);
	}

	@DeleteMapping
	public void deleteAll() {
		employeeService.deleteAll();
	}
	
	@PostMapping
	public void saveOrUpdate(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
	}

}
