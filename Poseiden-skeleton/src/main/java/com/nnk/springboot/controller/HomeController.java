package com.nnk.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class allows to intercept home requests
 */
@Controller
public class HomeController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	@RequestMapping("/")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		return "/home.html";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		logger.info("adminHome(" + model + ")");

		return "redirect:/bidList/list";
	}
}