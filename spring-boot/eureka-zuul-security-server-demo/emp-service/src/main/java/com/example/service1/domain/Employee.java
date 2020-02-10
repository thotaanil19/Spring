package com.example.service1.domain;

public class Employee {

	private Integer id;
	private String name;
	private String pnoneNumber;
	private String address;
	private Double salary;

	public Employee() {
	}

	public Employee(Integer id, String name, String pnoneNumber,
			String address, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.pnoneNumber = pnoneNumber;
		this.address = address;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnoneNumber() {
		return pnoneNumber;
	}

	public void setPnoneNumber(String pnoneNumber) {
		this.pnoneNumber = pnoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
