package com.src.model;

import com.src.an.Constraint;
import com.src.an.Table;
import com.src.an.TableAnnotation;

public class Admin {
	@Constraint(constraint = "primary key")
	private String username;
	private String password;
	private String name;
	@Constraint(constraint = "not null")
	private long mobile;
	@Constraint(constraint = "unique")
	private String email;
	private char gender;
	private String address;
	
	public Admin() {
		if(getClass().isAnnotationPresent(TableAnnotation.class)) {
			Table.createTable(this.getClass().getCanonicalName());
		}
		
	}
	public Admin(String username, String password, String name, long mobile, String email, char gender,
			String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
