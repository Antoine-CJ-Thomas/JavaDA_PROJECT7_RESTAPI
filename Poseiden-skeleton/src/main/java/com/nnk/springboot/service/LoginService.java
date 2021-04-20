package com.nnk.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepository;
import com.nnk.springboot.repository.UserRepositoryInterface;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;

	public LoginService() {
		
		userRepositoryInterface = new UserRepository();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		userRepositoryInterface = new UserRepository();
		
		return userRepositoryInterface.selectUser(new User(), username);
	}
}