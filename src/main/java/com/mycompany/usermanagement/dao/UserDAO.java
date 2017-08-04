package com.mycompany.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;

public interface UserDAO {
    
    public void saveOrUpdate(Users user);
     
    public void delete(int contactId);
     
    public Users get(int userId);
     
    public List<Users> list();
    
    public List<Group> listUserGroups(int i);
    public List<Group> listUserGroupsToAdd(int i);
    public void addUserToGroup(int i, int z);
    
    
}
