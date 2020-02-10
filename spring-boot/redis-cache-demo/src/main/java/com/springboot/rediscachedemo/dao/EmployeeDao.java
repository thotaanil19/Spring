package com.springboot.rediscachedemo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.springboot.rediscachedemo.dto.Employee;

@Repository
public class EmployeeDao {

	private static final Map<Integer, Employee> DB = new HashMap<>();

	@PostConstruct
	public void setUpData() {
		DB.put(1, new Employee(1, "Anil", 100D));
		DB.put(2, new Employee(2, "Kavi", 120D));
		DB.put(3, new Employee(3, "Madhu", 150D));
	}

	public Employee getById(Integer id) {
		return DB.get(id);
	}

	public void deleteById(Integer id) {
		DB.remove(id);
	}

	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<>();
		DB.forEach((k, v) -> {
			list.add(v);
		});
		return list;
	}

	public void deleteAll() {
		DB.clear();
	}

	public void saveOrUpdate(Employee employee) {
		DB.put(employee.getId(), employee);
	}

}
