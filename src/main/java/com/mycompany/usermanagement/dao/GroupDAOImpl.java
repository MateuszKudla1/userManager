package com.mycompany.usermanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mycompany.usermanagement.domain.Group;
import com.mycompany.usermanagement.domain.Users;

public class GroupDAOImpl implements GroupDAO {
	
	   private JdbcTemplate jdbcTemplate;
	   
	    public GroupDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }


	@Override
	public void saveOrUpdate(Group group) {
		
		  if (group.getId() > 0) {
			      //   update
			        String sql = "UPDATE Groups SET  groupname=? WHERE id=?";
		       jdbcTemplate.update(sql,group.getGroupname(),group.getId());
			   } else {
			        //insert
			        String sql = "INSERT INTO Groups (id,groupname) VALUES (group_sequence.NEXTVAL,?)";
			        System.out.println(group.getGroupname());
			        jdbcTemplate.update(sql,group.getGroupname() );
			   }
		
	}
	
	@Override
	public void deleteUserInGroup(int userId,int groupId) {
			String sql = "DELETE FROM membership WHERE GroupID="+groupId+" AND UserID="+userId;
		   
		 
		    int i = jdbcTemplate.update(sql);
		    System.out.println("user deleted from group"+groupId+" "+userId+"rows updated"+i+" "+sql);
		


		
		
	}

	@Override
	public void delete(int groupId) {
			String sql = "DELETE FROM membership WHERE GroupID=?";
		    String sql2 = "DELETE FROM Groups WHERE id=?";
		    System.out.println(groupId);
		  int i=  jdbcTemplate.update(sql, groupId);
		   
		   int z = jdbcTemplate.update(sql2, groupId);
		    System.out.println("rows updated"+i+" "+ z);
		
		
	}

	@Override
	public Group get(int groupId) {
		String sql = "SELECT * FROM Groups WHERE id="+groupId;
		 return jdbcTemplate.query(sql, new ResultSetExtractor<Group>() {
			 
		        @Override
		        public Group extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                Group g = new Group();
		                g.setId(rs.getInt("id"));
			            g.setGroupname(rs.getString("groupname"));
		                return g;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public List<Group> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Groups";
		
		List<Group> listgroup = jdbcTemplate.query(sql, new RowMapper<Group>() {
		    
			 
		      @Override
		        public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		            
		        	Group aGroup = new Group();
		 
		            aGroup.setId(rs.getInt("id"));
		            aGroup.setGroupname(rs.getString("groupname"));
		           
		            
		            System.out.println(aGroup.toString());
		          
		         
		      
		 
		            return aGroup;
		        }
		 
		    });
		
		
		
		    return  listgroup;
		
		
	}


	@Override
	public List<Users> listGroup(int i) {
		String sql = "SELECT Users.id, Users.password, Users.lastname,Users.firstname, Users.birthdate, Users.username FROM Users JOIN membership ON Users.id = membership.UserID JOIN Groups ON Groups.id = membership.GroupID  WHERE Groups.id ="+i;
		
		List<Users> listgroup = jdbcTemplate.query(sql, new RowMapper<Users>() {
		    
			 
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
		
		
		
		    return  listgroup;
		
		
	}

}
