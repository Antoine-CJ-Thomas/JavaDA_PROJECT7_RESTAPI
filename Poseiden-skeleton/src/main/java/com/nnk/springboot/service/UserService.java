package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepository;
import com.nnk.springboot.repository.UserRepositoryInterface;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;

	public UserService() {
		
		userRepositoryInterface = new UserRepository();
	}

	@Override
	public void createUser(User user) {
		
		userRepositoryInterface.insertUser(user);
	}


	@Override
	public User readUser(Integer id) {
		
		return userRepositoryInterface.selectUser(id);
	}


	@Override
	public ArrayList<User> readUserList() {
		
		return userRepositoryInterface.selectUserList();
	}


	@Override
	public void updateUser(Integer id, User user) {
		
		userRepositoryInterface.updatetUser(id, user);
	}


	@Override
	public void deleteUser(Integer id) {
		
		userRepositoryInterface.deleteUser(id);
	}
}