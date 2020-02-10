package com.example.service2.domain;

public class Department {

	private Integer id;
	private String name;
	private String pnoneNumber;
	private String address;
	private Integer employeesCount;

	public Department() {
	}

	public Department(Integer id, String name, String pnoneNumber,
			String address, Integer employeesCount) {
		super();
		this.id = id;
		this.name = name;
		this.pnoneNumber = pnoneNumber;
		this.address = address;
		this.employeesCount = employeesCount;
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

	public Integer getEmployeesCount() {
		return employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}

}
