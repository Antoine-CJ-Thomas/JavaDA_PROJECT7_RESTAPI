package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.User;

@Component
public class UserRepository implements UserRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("UserRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public UserRepository() {
		logger.info("UserRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertUser(User user) {
		logger.info("insertUser");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO users (username,password,fullname,role) VALUES ("
			
				+ "'" + user.getUsername() + "',"
				+ "'" + user.getPassword() + "',"
				+ "'" + user.getFullname() + "',"
				+ "'" + user.getRole() + "'"
				
        	+ ");";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public User selectUser(User user, String username) {
		logger.info("selectUser");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users WHERE username='" + username + "';";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
    	try {

			if (resultSet.next()) {

				user.setId(resultSet.getInt("Id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setFullname(resultSet.getString("fullname"));
				user.setRole(resultSet.getString("role"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
        
		return user;
	}

	@Override
	public User selectUser(Integer id) {
		logger.info("selectUser");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<User> selectUserList() {
		logger.info("selectUserList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetUser(Integer id, User user) {
		logger.info("updatetUser");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "INSERT INTO users (username,password,fullname,role) VALUES ("
		
			+ "'" + user.getUsername() + "',"
			+ "'" + user.getPassword() + "',"
			+ "'" + user.getFullname() + "',"
			+ "'" + user.getRole() + "'"
			
    	+ ") WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteUser(Integer id) {
		logger.info("deleteUser");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM users WHERE id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}