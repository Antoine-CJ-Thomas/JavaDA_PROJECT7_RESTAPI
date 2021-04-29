package com.nnk.springboot.controller;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import com.nnk.springboot.service.UserServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class allows to intercept user requests
 */
@Controller
public class UserController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private UserServiceInterface userServiceInterface;
	
	/**
	 * Creates a new UserController
	 */
	public UserController() {
		logger.info("UserController()");

		userServiceInterface = new UserService();
	}

	/**
	 * Creates a new UserController with the specified UserServiceInterface
	 * @param userServiceInterface : service that this controller will use
	 */
	public UserController(UserServiceInterface userServiceInterface) {
		logger.info("UserController(" + userServiceInterface + ")");

		this.userServiceInterface = userServiceInterface;
	}

	/**
	 * Intercepts the request of the user list table
	 * @param model : defines a holder for model attributes
     * @return The user list template
	 */
	@RequestMapping("/user/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("userList", userServiceInterface.readUserList());

		return "/user/list.html";
	}

	/**
	 * Intercepts the get request of the user creation form
	 * @param user : data of the User to create
     * @return The user creation form template
	 */
	@GetMapping("/user/add")
	public String addUserForm(User user) {
		logger.info("addUserForm(" + user + ")");

		return "/user/add.html";
	}

	/**
	 * Intercepts the post request of the user creation form
	 * @param user : data of the User to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the user list template or redirect to the user creation form
	 */
	@PostMapping("/user/validate")
	public String validate(@Valid User user, BindingResult bindingResult, Model model) {
		logger.info("validate(" + user + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

			userServiceInterface.createUser(user);

			return "redirect:/user/list";
		}

		return "/user/add.html";
	}

	/**
	 * Intercepts the get request of the user update form
	 * @param id : id of the user to update
	 * @param model : defines a holder for model attributes
     * @return Return the user update form template
	 */
	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("user", userServiceInterface.readUser(id));

		return "/user/update.html";
	}

	/**
	 * Intercepts the post request of the user update form
	 * @param id : id of the user to update
	 * @param user : data of the User to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the user list template or redirect to the user update form
	 */
	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult bindingResult, Model model) {
		logger.info("updateUser(" + id + "," + user + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			user.setId(id);
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

			userServiceInterface.updateUser(id, user);

			return "redirect:/user/list";
		}

		return "/user/update.html";
	}

	/**
	 * Intercepts the get request of the user delete
	 * @param id : id of the user to delete
	 * @param model : defines a holder for model attributes
     * @return Return the user list template
	 */
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteUser(" + id + "," + model + ")");
		
		userServiceInterface.deleteUser(id);

		return "redirect:/user/list";
	}
}
