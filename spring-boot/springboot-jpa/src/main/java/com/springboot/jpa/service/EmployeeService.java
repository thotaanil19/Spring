package com.springboot.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.dao.EmployeeRepository;
import com.springboot.jpa.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findEmployeeById(int id) {

		return employeeRepository.findById(id);

	}

	public List<Employee> findAllEmployees() {

		return employeeRepository.findAll();

	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public boolean delete(int id) {
		employeeRepository.deleteById(id);
		return true;
	}

	public Employee update(Employee employee) {
		Employee empInDB = findEmployeeById(employee.getId());
		if (employee.getName() != null) {
			empInDB.setName(employee.getName());
		}
		if (employee.getSalary() != null) {
			empInDB.setSalary(employee.getSalary());
		}
		if (employee.getAddress() != null) {
			empInDB.setAddress(employee.getAddress());
		}
		return save(empInDB);
	}

}
