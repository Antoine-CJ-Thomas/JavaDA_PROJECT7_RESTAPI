package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import com.nnk.springboot.service.UserServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class allows to intercept user REST requests
 */
@RestController
public class UserRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private UserServiceInterface userServiceInterface;
	
	/**
	 * Creates a new UserRestController
	 */
	public UserRestController() {
		logger.info("UserController()");

		userServiceInterface = new UserService();
	}

	/**
	 * Creates a new UserRestController with the specified UserServiceInterface
	 * @param userServiceInterface : service that this controller will use
	 */
	public UserRestController(UserServiceInterface userServiceInterface) {
		logger.info("UserController(" + userServiceInterface + ")");

		this.userServiceInterface = userServiceInterface;
	}

	/**
	 * Intercepts the creating request of an user
	 * @param user : data of the User to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/user/create")
	public void createUser(@Valid User user, BindingResult bindingResult) {
		logger.info("createUser(" + user + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

			userServiceInterface.createUser(user);
		}
	}

	/**
	 * Intercepts the getting request of an user
	 * @param id : id of the user to read
     * @return Return the user (JSon)
	 */
	@GetMapping("/user/read")
	public String readUser(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readUser(" + id + ")");

        return objectMapper.writeValueAsString(userServiceInterface.readUser(id));
	}

	/**
	 * Intercepts the updating request of an user
	 * @param id : id of the user to update
	 * @param user : data of the User to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/user/update")
	public void updateUser(@RequestParam("id") Integer id, @Valid User user, BindingResult bindingResult) {
		logger.info("updateUser(" + id + "," + user + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

			userServiceInterface.updateUser(id, user);
		}
	}

	/**
	 * Intercepts the deleting request of an user
	 * @param id : id of the user to delete
	 */
	@DeleteMapping("/user/delete")
	public void deleteUser(@RequestParam("id") Integer id) {
		logger.info("deleteUser(" + id + ")");
		
		userServiceInterface.deleteUser(id);
	}
}