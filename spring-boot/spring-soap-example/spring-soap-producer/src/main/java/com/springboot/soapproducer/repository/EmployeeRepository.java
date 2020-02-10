package com.springboot.soapproducer.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.springboot.employee.Dept;
import com.springboot.employee.Employee;

@Component
public class EmployeeRepository {
	private static final Map<Integer, Employee> employees = new HashMap<>();

	@PostConstruct
	public void initData() {
		Dept dept1 = new Dept();
		 dept1.setId(1000);
		 dept1.setName("CSE");

		Employee employee1 = new Employee();
		employee1.setName("Anil");
		employee1.setId(1);
		employee1.setSal(100);
		employee1.setDept(dept1);
		
		Employee employee2 = new Employee();
		employee2.setName("Kavitha");
		employee2.setId(2);
		employee2.setSal(200);
		employee2.setDept(dept1);
		
		employees.put(employee1.getId(), employee1);
		employees.put(employee2.getId(), employee2);
	}

	public Employee findEmployee(Integer id) {
		Assert.notNull(id, "The employee's id must not be null");
		return employees.get(id);
	}
}
