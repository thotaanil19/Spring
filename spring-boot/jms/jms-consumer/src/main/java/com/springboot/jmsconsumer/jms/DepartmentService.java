package com.springboot.jmsconsumer.jms;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.jmsconsumer.dto.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	
	  @JmsListener(destination = "dept-queue") public void process1(String message)
	  throws Exception { ObjectMapper mapper = new ObjectMapper(); Department
	  department = mapper.readValue(message, Department.class); log.info("dept",
	  department); }
	 
	
	@JmsListener(destination = "dept-topic", containerFactory = "DefaultJmsListenerContainerFactory-topic")
	public void process2(String message) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Department department = mapper.readValue(message, Department.class);
		log.info("dept", department);
	}
	
	
	@Value("${spring.activemq.broker-url}")
	  private String brokerUrl;

	
	  @Bean public ActiveMQConnectionFactory activeMQConnectionFactory() {
	  ActiveMQConnectionFactory activeMQConnectionFactory = new
	  ActiveMQConnectionFactory();
	  activeMQConnectionFactory.setBrokerURL(brokerUrl);
	  
	  return activeMQConnectionFactory; }
	 

	  @Bean("DefaultJmsListenerContainerFactory")
	  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory1() {
	    DefaultJmsListenerContainerFactory factory =
	        new DefaultJmsListenerContainerFactory();
	    factory
	        .setConnectionFactory(activeMQConnectionFactory());

	    return factory;
	  }
	  
	  @Bean("DefaultJmsListenerContainerFactory-topic")
	  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory2() {
	    DefaultJmsListenerContainerFactory factory =
	        new DefaultJmsListenerContainerFactory();
	    factory
	        .setConnectionFactory(activeMQConnectionFactory());
	    factory.setPubSubDomain(true);

	    return factory;
	  }

}
