package com.nnk.springboot.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnk.springboot.repository.UserRepository;
import com.nnk.springboot.repository.UserRepositoryInterface;

/**
 * This class allows to interact with a user repository in order to login
 */
@Service
public class LoginService implements UserDetailsService {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private UserRepositoryInterface userRepositoryInterface;

	public LoginService() {
		logger.info("LoginService()");

		userRepositoryInterface = new UserRepository();
	}

	public LoginService(UserRepositoryInterface userRepositoryInterface) {
		logger.info("LoginService(" + userRepositoryInterface + ")");

		this.userRepositoryInterface = userRepositoryInterface;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername(" + username + ")");

		return userRepositoryInterface.selectUser(username);
	}
}