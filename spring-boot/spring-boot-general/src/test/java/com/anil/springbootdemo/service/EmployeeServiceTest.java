package com.anil.springbootdemo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private AbstractService abstractService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testmethod() {
		Mockito.when(abstractService.method()).
		thenReturn("TEST");
		String val = employeeService.method();
		Assert.assertNotNull(val);
	}
	
	
	
	
	
}
