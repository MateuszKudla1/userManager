package com.mycompany.usermanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mycompany.usermanagement.dao.GroupDAO;
import com.mycompany.usermanagement.dao.UserDAO;
import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;


@Controller
public class HomeController {
	
	 

	
	

	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	GroupDAO groupDAO;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "User Management!");
		
		
		return "welcome";
	}
	
	@RequestMapping("/user/addUser")
	public String register(Model model){
		
		return "register";
	}
	
	
	
	 
	 
	 @RequestMapping(value="/user", method=RequestMethod.GET)
	 public ResponseEntity<List<Users>> get() {
		 
		 List<Users> list = userDAO.list();
	
	 
	 return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/user/{userID}", method=RequestMethod.DELETE)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable("userID") String id) {
	
	int i= Integer.parseInt(id);
		 userDAO.delete(i);

	 }
	 
	 @RequestMapping(value="/user", method=RequestMethod.POST)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void edit(@RequestBody  Users u) {
		 Users p = new Users(u.getId(),u.getLastname(),u.getFirstname(),u.getUsername(),u.getBirthdate(),u.getPassword());
		 System.out.println(p.toString());
		 System.out.println("to co przyslalo");
	        userDAO.saveOrUpdate(p);
	        
	        
	    }
	 
	 @RequestMapping(value="/user/newUser", method=RequestMethod.POST)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void add(@RequestBody  Users u) {
		 Users p = new Users(u.getId(),u.getLastname(),u.getFirstname(),u.getUsername(),u.getBirthdate(),u.getPassword());
		 System.out.println(p.toString());
		 System.out.println("to co przyslalo");
	        userDAO.saveOrUpdate(p);
	        
	        
	    }
	 
}
