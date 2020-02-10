package com.springboot.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.domain.Employee;
import com.springboot.mongodb.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<Employee> get(@PathVariable String id) {
		LOGGER.info("Start: /emp/get/" + id);
		ResponseEntity<Employee> response = null;
		try {
			Employee emp = employeeService.get(id);
			response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End: /emp/get/" + id);
		return response;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		LOGGER.info("Start: /emp/get");
		ResponseEntity<List<Employee>> response = null;
		try {
			List<Employee> emps = employeeService.getAll();
			response = new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End: /emp/get");
		return response;
	}

	@GetMapping("/getAllByName/{name}")
	public ResponseEntity<List<Employee>> getAllByName(@PathVariable String name) {
		LOGGER.info("Start: /emp/get");
		ResponseEntity<List<Employee>> response = null;
		try {
			List<Employee> emps = employeeService.getAllByNameWithMongoMorphia(name);
			response = new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End: /emp/get");
		return response;
	}

	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee emp) {
		LOGGER.info("Start: /emp/save");
		ResponseEntity<Employee> response = null;
		try {
			Employee emp2 = employeeService.save(emp);
			response = new ResponseEntity<Employee>(emp2, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End: /emp/save");
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {
		LOGGER.info("Start: /emp/delete(" + id + ")");
		ResponseEntity<Boolean> response = null;
		try {
			boolean deleteStatus = employeeService.delete(id);
			response = new ResponseEntity<Boolean>(deleteStatus, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End: /emp/delete(" + id + ")");
		return response;
	}

}
