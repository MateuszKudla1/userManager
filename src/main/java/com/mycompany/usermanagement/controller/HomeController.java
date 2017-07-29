package com.mycompany.usermanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.usermanagement.domain.Persons;
import com.mycompany.usermanagement.domain.Quote;
import com.mycompany.usermanagement.domain.User;
import com.mycompany.usermanagement.service.QuoteService;
import com.mycompany.usermanagement.service.UserService;

@Controller

public class HomeController {
	
	UserService userService = new UserService();
	Persons p = new Persons();
	ArrayList<User> list = new ArrayList<User>();
	
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "User Management!");
		
		
		return "welcome";
	}
	
	
	
	 
	 
	 @RequestMapping(value="/user", method=RequestMethod.GET)
	 public ResponseEntity<ArrayList<User>> get() {
	 list = userService.getUser2();
	 return new ResponseEntity<ArrayList<User>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/user", method=RequestMethod.DELETE)
	 public ResponseEntity<ArrayList<User>> delete() {
	 list = userService.getUser2();
	 list.remove(1);
	 System.out.println(list.size());
	 return new ResponseEntity<ArrayList<User>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
}
