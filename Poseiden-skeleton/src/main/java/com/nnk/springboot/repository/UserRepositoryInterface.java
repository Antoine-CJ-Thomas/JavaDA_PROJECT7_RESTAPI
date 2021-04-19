package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.User;

public interface UserRepositoryInterface {

	public void insertUser(User user);
	
	public User selectUser(Integer id);
	
	public ArrayList<User> selectUserList();
	
	public void updatetUser(Integer id, User user);
	
	public void deleteUser(Integer id);
}