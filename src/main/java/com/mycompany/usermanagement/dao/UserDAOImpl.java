package com.mycompany.usermanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;

public class UserDAOImpl implements UserDAO {
	
	   private JdbcTemplate jdbcTemplate;
	   
	    public UserDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	@Override
	public void saveOrUpdate(Users user) {
		
		  if (user.getId() > 0) {
		   //      update
		        String sql = "UPDATE Users SET  lastname=?, firstname=?, "
		                    + "birthdate=?,username=? WHERE id=?";
		       jdbcTemplate.update(sql,user.getLastname(),user.getFirstname(),user.getBirthdate(),user.getUsername(),user.getId());
		    } else {
		        //insert
		        String sql = "INSERT INTO Users (id,password, lastname, firstname,birthdate, username)"
		                    + " VALUES (?, ?, ?, ?,?,?)";
		        jdbcTemplate.update(sql,user.getId(), user.getPassword(), user.getLastname(),user.getFirstname(),
		        		user.getBirthdate(),user.getUsername() );
		    }
	}

	@Override
	public void delete(int userId) {
		String sql2 = "DELETE FROM membership WHERE UserID = ?";
	    String sql = "DELETE FROM Users WHERE id=?";
	    jdbcTemplate.update(sql2, userId);
	    jdbcTemplate.update(sql, userId);
	}
		
	

	@Override
	public Users get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> list() {
		
		 String sql = "SELECT * FROM Users ORDER BY lastname";
		
		    List<Users> listContact = jdbcTemplate.query(sql, new RowMapper<Users>() {
		    
		 
		      @Override
		        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		            
		        	Users aUser = new Users();
		 
		            aUser.setId(rs.getInt("id"));
		            aUser.setFirstname(rs.getString("firstname"));
		            aUser.setLastname(rs.getString("lastname"));
		            aUser.setUsername(rs.getString("username"));
		            aUser.setBirthdate(rs.getString("birthdate"));
		            
		            System.out.println(aUser.toString());
		          
		         
		      
		 
		            return aUser;
		        }
		 
		    });
		
		    return  listContact;
	}

	@Override
	public List<Group> listUserGroups(int i) {
		String sql ="SELECT Groups.groupname, Groups.id FROM Users join membership ON Users.id = membership.UserID join Groups ON Groups.id = membership.GroupID WHERE Users.id = "+i;
		
		   List<Group> listGroups = jdbcTemplate.query(sql, new RowMapper<Group>() {
			    
				 
			      @Override
			        public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			            
			        	Group group = new Group();
			 
			            group.setId(rs.getInt("id"));
			            group.setGroupname(rs.getString("groupname"));
			           
			            
			            System.out.println(group.toString());
			          
			         
			      
			 
			            return group;
			        }
			 
			    });
			
			    return  listGroups;
			    
	}

	@Override
	public List<Group> listUserGroupsToAdd(int i) {
		
		String sql ="SELECT Groups.id,Groups.groupname FROM Groups"+  
" minus SELECT Groups.id,Groups.groupname FROM Users left join membership on Users.id = membership.UserID LEFT JOIN Groups ON membership.GroupID = Groups.id WHERE  Users.id ="+i;
		
		  List<Group> listGroups = jdbcTemplate.query(sql, new RowMapper<Group>() {
			    
				 
		      @Override
		        public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		            
		        	Group group = new Group();
		 
		            group.setId(rs.getInt("id"));
		            group.setGroupname(rs.getString("groupname"));
		           
		            
		            System.out.println(group.toString());
		          
		         
		      
		 
		            return group;
		        }
		 
		    });
		
		    return  listGroups;
		    
}

	@Override
	public void addUserToGroup(int i, int z) {
		String sql = "INSERT INTO membership (UserID,GroupID) VALUES (?,?)";
		jdbcTemplate.update(sql,i,z );
		
		
	}
	
	
	
}
