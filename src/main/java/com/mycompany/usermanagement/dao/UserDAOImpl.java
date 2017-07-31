package com.mycompany.usermanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	    String sql = "DELETE FROM Users WHERE id=?";
	    jdbcTemplate.update(sql, userId);
	}
		
	

	@Override
	public Users get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> list() {
		
		 String sql = "SELECT * FROM Users";
		
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

	
	
	
}
