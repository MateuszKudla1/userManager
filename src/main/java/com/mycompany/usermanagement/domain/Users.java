package com.mycompany.usermanagement.domain;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	
	






	private int id;
	private String lastname;
	private String password;
	private String birthdate;
	private String username;
	private String firstname;
	
	public Users(int id,String lastname, String firstname, String name,String birthdate,String password){
		this.id = id;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.username = name;
		this.firstname = firstname;
		this.password = password;
		
	}
	
	public Users(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [lastname=" + lastname + ", age="  + ", password=" + password + ", date="  + ", name="
				+ username + ", firstname=" + firstname + "]";
	}
	
	


	

}
