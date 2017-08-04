package com.mycompany.usermanagement.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
	
	public Group(int id, String groupname){
		this.id = id;
		this.groupname = groupname;
		
	}
	
	public Group(){
		
	}
	
	
	private int id;

	private String groupname;
	

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}



	
	
	
	
	

	

}
