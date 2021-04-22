package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.User;

/**
 * This interface allows to implement user repository methods
*/
public interface UserRepositoryInterface {

	public void insertUser(User user);

	public User selectUser(String username);
	
	public User selectUser(Integer id);
	
	public ArrayList<User> selectUserList();
	
	public void updateUser(Integer id, User user);
	
	public void deleteUser(Integer id);
}