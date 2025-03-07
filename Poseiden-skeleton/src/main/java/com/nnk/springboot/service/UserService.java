package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepository;
import com.nnk.springboot.repository.UserRepositoryInterface;

/**
 * This class allows to interact with an user repository
 */
@Service
public class UserService implements UserServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private UserRepositoryInterface userRepositoryInterface;

	/**
	 * Creates a new UserService
	 */
	public UserService() {
		logger.info("UserService()");

		userRepositoryInterface = new UserRepository();
	}

	/**
	 * Creates a new UserService with the specified UserRepositoryInterface
	 * @param userRepositoryInterface : repository that this service will use
	 */
	public UserService(UserRepositoryInterface userRepositoryInterface) {
		logger.info("UserService(" + userRepositoryInterface + ")");

		this.userRepositoryInterface = userRepositoryInterface;
	}

	@Override
	public void createUser(User user) {
		logger.info("createUser(" + user + ")");

		userRepositoryInterface.insertUser(user);
	}

	@Override
	public User readUser(Integer id) {
		logger.info("readUser(" + id + ")");

		return userRepositoryInterface.selectUser(id);
	}

	@Override
	public ArrayList<User> readUserList() {
		logger.info("readUserList()");

		return userRepositoryInterface.selectUserList();
	}

	@Override
	public void updateUser(Integer id, User user) {
		logger.info("updateUser(" + id + "," + user + ")");

		userRepositoryInterface.updateUser(id, user);
	}

	@Override
	public void deleteUser(Integer id) {
		logger.info("deleteUser(" + id + ")");

		userRepositoryInterface.deleteUser(id);
	}
}