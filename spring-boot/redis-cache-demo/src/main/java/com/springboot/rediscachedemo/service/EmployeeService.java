package com.springboot.rediscachedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.rediscachedemo.dao.EmployeeDao;
import com.springboot.rediscachedemo.dto.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Cacheable(value="Employees", key="#id", unless="#result == null")
	public Employee getById(Integer id) {
		return employeeDao.getById(id);
	}

	@CacheEvict(value="Employees", key="#id")
	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}
	
	@Cacheable(value="Employees", unless="#result == null")
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@CacheEvict(value="Employees")
	public void deleteAll() {
		employeeDao.deleteAll();
	}

	@CachePut(value="Employees", key="#employee.id")
	public Employee saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
		return employee;
	}
	
}
