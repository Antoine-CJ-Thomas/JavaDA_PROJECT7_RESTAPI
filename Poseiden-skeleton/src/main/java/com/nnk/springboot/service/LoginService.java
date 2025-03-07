package com.nnk.springboot.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepository;
import com.nnk.springboot.repository.UserRepositoryInterface;

/**
 * This class allows to interact with a user repository in order to login
 */
@Service
public class LoginService implements LoginServiceInterface, UserDetailsService {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private UserRepositoryInterface userRepositoryInterface;

	/**
	 * Creates a new LoginService
	 */
	public LoginService() {
		logger.info("LoginService()");

		userRepositoryInterface = new UserRepository();
	}

	/**
	 * Creates a new LoginService with the specified UserRepositoryInterface
	 * @param userRepositoryInterface : repository that this service will use
	 */
	public LoginService(UserRepositoryInterface userRepositoryInterface) {
		logger.info("LoginService(" + userRepositoryInterface + ")");

		this.userRepositoryInterface = userRepositoryInterface;
	}

	@Override
	public String getUsername() {
		
		String username = null;
	    
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
        	
        	if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass() == User.class) {

        		username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        		
        	}
        	
        	else if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass() == DefaultOAuth2User.class) {

        		username = ((DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttribute("login");
        	}
        }
        
		return username;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername(" + username + ")");

		if (userRepositoryInterface.selectUser(username) == null) {
			
			return new User();
		}
		
		else {

			return userRepositoryInterface.selectUser(username);
		}
	}
}