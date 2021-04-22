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

	public UserController() {
		logger.info("UserController()");

		userServiceInterface = new UserService();
	}

	@RequestMapping("/user/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("userList", userServiceInterface.readUserList());

		return "/user/list.html";
	}

	@GetMapping("/user/add")
	public String addUser(User user) {
		logger.info("addUser(" + user + ")");

		return "/user/add.html";
	}

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

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("user", userServiceInterface.readUser(id));

		return "/user/update.html";
	}

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

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteUser(" + id + "," + model + ")");
		
		userServiceInterface.deleteUser(id);

		return "redirect:/user/list";
	}
}
