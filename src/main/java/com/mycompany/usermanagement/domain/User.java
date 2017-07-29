package com.mycompany.usermanagement.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	public User(){
		
	}
	
	private String lastname;
	private int age;
	private String password;
	private Date date;
	private String name;
	
	private String firstname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [lastname=" + lastname + ", age=" + age + ", password=" + password + ", date=" + date + ", name="
				+ name + ", firstname=" + firstname + "]";
	}
	
	


	

}
