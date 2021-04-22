package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.User;

/**
 * This interface allows to implement user service methods
*/
public interface UserServiceInterface {

	public void createUser(User user);

	public User readUser(Integer id);

	public ArrayList<User> readUserList();

	public void updateUser(Integer id, User user);

	public void deleteUser(Integer id);
}
