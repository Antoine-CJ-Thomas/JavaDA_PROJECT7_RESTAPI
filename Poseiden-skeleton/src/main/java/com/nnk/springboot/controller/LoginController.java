package com.nnk.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger("LoginController");

	// @Autowired
	// private UserRepositoryInterface userRepository;

	@GetMapping("/TEST/login")
	public String login() {
		logger.info("login");

//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login");
//		return mav;
		
		return "login";
	}

	@GetMapping("/TEST/secure/article-details")
	public String getAllUserArticles() {
		logger.info("getAllUserArticles");

//		ModelAndView mav = new ModelAndView();
//        mav.addObject("users", userRepository.findAll());
//		mav.setViewName("user/list");
//		return mav;
		
		return "getAllUserArticles";
	}

	@GetMapping("/TEST/error")
	public String error() {
		logger.info("error");

//		ModelAndView mav = new ModelAndView();
//		String errorMessage = "You are not authorized for the requested data.";
//        mav.addObject("errorMsg", errorMessage);
//		mav.setViewName("403");
//		return mav;
		
		return "error";
	}
}
