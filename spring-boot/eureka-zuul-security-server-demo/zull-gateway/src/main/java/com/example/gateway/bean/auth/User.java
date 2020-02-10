package com.example.gateway.bean.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

	@Id
	private String id;
	
	@Email(message = "*Please provide a valid email")
	@NotEmpty(message = "*Please provide an email")
	@Column
	private String email;
	
	@NotEmpty(message = "*Please provide your name")
	@Column
	private String password;
	
	@NotEmpty(message = "*Please provide your name")
	@Column
	private String name;
	
	@NotEmpty(message = "*Please provide your last name")
	@Column
	private String lastName;
	
	@Column
	private Integer active = 1;
	
	@Column
	private boolean isLoacked = false;
	
	@Column
	private boolean isExpired = false;
	
	@Column
	private boolean isEnabled = true;
	
	//@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	//private Set<Role> role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	/*public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}*/

	public boolean isLoacked() {
		return isLoacked;
	}

	public void setLoacked(boolean loacked) {
		isLoacked = loacked;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean expired) {
		isExpired = expired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean enabled) {
		isEnabled = enabled;
	}

}
