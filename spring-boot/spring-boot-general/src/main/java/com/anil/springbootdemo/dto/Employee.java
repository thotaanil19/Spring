package com.anil.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	
	private String name;
	
	//@JsonProperty("isActive")
	private boolean isActive;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public boolean isActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", isActive=" + isActive + "]";
	}
	

}
