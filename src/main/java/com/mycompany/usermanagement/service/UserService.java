package com.mycompany.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.usermanagement.domain.Persons;
import com.mycompany.usermanagement.domain.Quote;
import com.mycompany.usermanagement.domain.User;

public class UserService {
	ArrayList<User> list = new ArrayList<User>();
	public UserService(){
		User q = new User();
		q.setAge(23);
		q.setFirstname("Mateusz");
		q.setLastname("Kud³a");
		User b = new User();
		b.setAge(21);
		b.setFirstname("Jagoda");
		b.setLastname("Czechowska");
		
		list.add(q);
		list.add(b);
	}
	
	public ArrayList<User> getUser2(){
		
		
		return list;
	}

}
