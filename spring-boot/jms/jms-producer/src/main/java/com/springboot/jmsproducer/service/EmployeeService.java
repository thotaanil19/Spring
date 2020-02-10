package com.springboot.jmsproducer.service;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.springboot.jmsproducer.dto.Employee;

@Service
@Configuration
public class EmployeeService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Employee emp) throws Exception {
		Queue queue = new ActiveMQQueue("employee-queue");
		jmsTemplate.convertAndSend(queue, emp);
	}

	

}
