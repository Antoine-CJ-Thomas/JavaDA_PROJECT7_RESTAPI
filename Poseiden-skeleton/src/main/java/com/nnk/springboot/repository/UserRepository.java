package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.User;

/**
 * This class allows to prepare queries for the user table and send them to the database configured
 */
@Component
public class UserRepository implements UserRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public UserRepository() {
		logger.info("UserRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}
	
	public UserRepository(DataBaseConfigurationInterface dataBaseConfigurationInterface) {
		logger.info("UserRepository(" + dataBaseConfigurationInterface + ")");

		this.dataBaseConfigurationInterface = dataBaseConfigurationInterface;
	}

	@Override
	public void insertUser(User user) {
		logger.info("insertUser(" + user + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "users ("
				
					+ "username,"
					+ "password,"
					+ "fullname,"
					+ "role) "
				
				+ "VALUES ("
			
					+ "'" + user.getUsername() + "',"
					+ "'" + user.getPassword() + "',"
					+ "'" + user.getFullname() + "',"
					+ "'" + user.getRole() + "');";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public User selectUser(String username) {
		logger.info("selectUser(" + username + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users WHERE username='" + username + "';";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		User user = null;
		
    	try {

			if (resultSet.next()) {
				
				user = new User();

				user.setId(resultSet.getInt("id"));
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
			
			dataBaseConfigurationInterface.close();
	    }
        
		return user;
	}

	@Override
	public User selectUser(Integer id) {
		logger.info("selectUser(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users WHERE Id=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		User user = null;
		
    	try {

			if (resultSet.next()) {
				
				user = new User();

				user.setId(resultSet.getInt("id"));
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
			
			dataBaseConfigurationInterface.close();
	    }
        
		return user;
	}

	@Override
	public ArrayList<User> selectUserList() {
		logger.info("selectUserList()");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM users";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<User> userList = new ArrayList<User>();
		
    	try {

			while (resultSet.next()) {

				User user = new User();

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setFullname(resultSet.getString("fullname"));
				user.setRole(resultSet.getString("role"));
				
				userList.add(user);
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
			
			dataBaseConfigurationInterface.close();
	    }
        
		return userList;
	}

	@Override
	public void updateUser(Integer id, User user) {
		logger.info("updateUser(" + id + "," + user + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "UPDATE users "
		
			+ "SET "
			
				+ "username=" + "'" + user.getUsername() + "',"
				+ "password=" + "'" + user.getPassword() + "',"
				+ "fullname=" + "'" + user.getFullname() + "',"
				+ "role=" + "'" + user.getRole() + "'"
		
    		+ "WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public void deleteUser(Integer id) {
		logger.info("deleteUser(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM users WHERE id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}
}