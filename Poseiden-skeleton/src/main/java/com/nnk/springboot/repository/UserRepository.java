package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.User;

@Component
public class UserRepository implements UserRepositoryInterface {

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public UserRepository() {
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertUser(User user) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public User selectUser(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<User> selectUserList() {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetUser(Integer id, User user) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteUser(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}