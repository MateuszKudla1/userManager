package com.mycompany.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mycompany.usermanagement.dao.GroupDAO;
import com.mycompany.usermanagement.dao.UserDAO;
import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;

@Controller
public class GroupController {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	GroupDAO groupDAO;
	

	@RequestMapping("/Allgroups")
	public String groups(Model model){
		
		return "groups";
	}
	
	@RequestMapping("/Addgroup")
	public String addGroup(Model model){
		
		return "Addgroup";
	}
	
	
	
	@RequestMapping("/group")
	public String group(Model model){
		
		
		return "UsersInGroup";
	}
	
	 @RequestMapping(value="/groups/{id}", method=RequestMethod.GET)
	 public ResponseEntity<Group> getGroupId(@PathVariable("id") String id) {
		int i = Integer.parseInt(id);
		
		 
		Group g = groupDAO.get(i);
		
	
	 
	 return new ResponseEntity<Group>(g, new HttpHeaders(), HttpStatus.OK);
	 }
	
	 @RequestMapping(value="/group/{id}", method=RequestMethod.GET)
	 public ResponseEntity<List<Users>> getGroup(@PathVariable("id") String id) {
		// Group g = new Group();
		// g.setGroupname("druga");
		// groupDAO.saveOrUpdate(g);
		 int i = Integer.parseInt(id);
		List<Users> list = groupDAO.listGroup(i);
		 
	
	 
	 return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	
	 @RequestMapping(value="/groups", method=RequestMethod.GET)
	 public ResponseEntity<List<Group>> getGroups() {
//	 Group g = new Group();
 //g.setGroupname("nowa");
	//	 groupDAO.saveOrUpdate(g);
		 
		List<Group> list = groupDAO.list();
		 
	
	 
	 return new ResponseEntity<List<Group>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/groups/{id}", method=RequestMethod.DELETE)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	 public void deleteGroup(@PathVariable("id") String id) {
	
	int i= Integer.parseInt(id);
		 groupDAO.delete(i);

	 }
	 
	 @RequestMapping(value="/Addgroup", method=RequestMethod.POST)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void addGroupPost(@RequestBody  Group g) {
		Group s = new Group(g.getId(),g.getGroupname());
		
		 System.out.println("to co przyslalo");
		 System.out.println(s.getGroupname()+" "+s.getId());
	        groupDAO.saveOrUpdate(s);
	        
	        
	    }
	 
	 
	 @RequestMapping(value="/Allgroup", method=RequestMethod.POST)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void editGroupName(@RequestBody  Group g) {
		Group s = new Group(g.getId(),g.getGroupname());
		
		 System.out.println("to co przyslalo");
		 System.out.println(s.getGroupname()+" "+s.getId());
	        groupDAO.saveOrUpdate(s);
	        
	        
	    }
	
	
}
