package com.capgemini.springbatch.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "report")
public class Report {

	private String id;
	private String name;
	private Double sal;
	private Integer age;

}
