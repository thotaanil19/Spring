package com.springboot.jmsconsumer.jms;


import javax.jms.TextMessage;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Configuration
@Slf4j
public class EmployeeService {
	
	@JmsListener(destination = "employee-queue")
	public void process(TextMessage message) throws Exception {
		log.info(message.getText());
	}
	
	

	/*
	 * @Component public class EmployeeMessageConverter implements MessageConverter
	 * {
	 * 
	 * ObjectMapper mapper;
	 * 
	 * public EmployeeMessageConverter() { mapper = new ObjectMapper(); }
	 * 
	 * @Override public Message toMessage(Object object, Session session) throws
	 * JMSException { Employee person = (Employee) object; String payload = null;
	 * try { payload = mapper.writeValueAsString(person);
	 * LOGGER.info("outbound json='{}'", payload); } catch (JsonProcessingException
	 * e) { LOGGER.error("error converting form person", e); }
	 * 
	 * TextMessage message = session.createTextMessage(); message.setText(payload);
	 * 
	 * return message; }
	 * 
	 * @Override public Object fromMessage(Message message) throws JMSException {
	 * TextMessage textMessage = (TextMessage) message; String payload =
	 * textMessage.getText(); LOGGER.info("inbound json='{}'", payload);
	 * 
	 * Employee person = null; try { person = mapper.readValue(payload,
	 * Employee.class); } catch (Exception e) {
	 * LOGGER.error("error converting to person", e); }
	 * 
	 * return person; } }
	 */
	

}
