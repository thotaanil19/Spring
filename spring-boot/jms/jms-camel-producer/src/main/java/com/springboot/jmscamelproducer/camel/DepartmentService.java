package com.springboot.jmscamelproducer.camel;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Service;

import com.springboot.jmscamelproducer.dto.Department;

@Service
@Configuration
public class DepartmentService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Department dept) throws Exception {
		//Queue queue = new ActiveMQQueue("dept-queue");
		Topic topic = new ActiveMQTopic("dept-topic");
		//jmsTemplate.convertAndSend(queue, dept);
		jmsTemplate.convertAndSend(topic, dept);
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
