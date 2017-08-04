package com.mycompany.usermanagement.dao;

import java.util.List;

import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;

public interface GroupDAO {
	
	 public void saveOrUpdate(Group group);
     
	    public void delete(int groupId);
	     
	    public Group get(int userId);
	     
	    public List<Group> list();
	    
	    public List<Users> listGroup(int i);
	    
	    public void deleteUserInGroup(int groupId,int userId);
	    
	    

}
