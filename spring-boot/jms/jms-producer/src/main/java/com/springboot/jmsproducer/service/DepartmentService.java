package com.springboot.jmsproducer.service;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.springboot.jmsproducer.dto.Department;

@Service
@Configuration
public class DepartmentService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Department dept) throws Exception {
		//Queue queue = new ActiveMQQueue("dept-queue");
		Topic topic = new ActiveMQTopic("dept-topic");
		jmsTemplate.convertAndSend(topic, dept);
	}

	

}
