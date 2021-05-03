package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.LoginService;
import com.nnk.springboot.service.LoginServiceInterface;
import com.nnk.springboot.service.RatingService;
import com.nnk.springboot.service.RatingServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class allows to intercept rating requests
 */
@Controller
public class RatingController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private RatingServiceInterface ratingServiceInterface;
	private LoginServiceInterface loginServiceInterface;
	
	/**
	 * Creates a new RatingController
	 */
	public RatingController() {
		logger.info("RatingController()");

		ratingServiceInterface = new RatingService();
		loginServiceInterface = new LoginService();
	}

	/**
	 * Creates a new RatingController with the specified RatingServiceInterface and LoginServiceInterface
	 * @param ratingServiceInterface : rating service that this controller will use
	 * @param loginServiceInterface : login service that this controller will use
	 */
	public RatingController(RatingServiceInterface ratingServiceInterface, LoginServiceInterface loginServiceInterface) {
		logger.info("RatingController(" + ratingServiceInterface + "," + loginServiceInterface + ")");

		this.ratingServiceInterface = ratingServiceInterface;
		this.loginServiceInterface = loginServiceInterface;
	}

	/**
	 * Intercepts the request of the rating list table
	 * @param model : defines a holder for model attributes
     * @return The rating list template
	 */
	@RequestMapping("/rating/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("username", loginServiceInterface.getUsername());

		model.addAttribute("ratingList", ratingServiceInterface.readRatingList());

		return "/rating/list.html";
	}

	/**
	 * Intercepts the get request of the rating creation form
	 * @param rating : data of the Rating to create
     * @return The rating creation form template
	 */
	@GetMapping("/rating/add")
	public String addRatingForm(Rating rating) {
		logger.info("addRatingForm(" + rating + ")");

		return "/rating/add.html";
	}

	/**
	 * Intercepts the post request of the rating creation form
	 * @param rating : data of the Rating to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the rating list template or redirect to the rating creation form
	 */
	@PostMapping("/rating/validate")
	public String validate(@Valid Rating rating, BindingResult bindingResult, Model model) {
		logger.info("validate(" + rating + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			ratingServiceInterface.createRating(rating);

			return "redirect:/rating/list";
		}

		return "/rating/add.html";
	}

	/**
	 * Intercepts the get request of the rating update form
	 * @param id : id of the rating to update
	 * @param model : defines a holder for model attributes
     * @return Return the rating update form template
	 */
	@GetMapping("/rating/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("rating", ratingServiceInterface.readRating(id));

		return "/rating/update.html";
	}

	/**
	 * Intercepts the post request of the rating update form
	 * @param id : id of the rating to update
	 * @param rating : data of the Rating to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the rating list template or redirect to the rating update form
	 */
	@PostMapping("/rating/update/{id}")
	public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating, BindingResult bindingResult,
			Model model) {
		logger.info("updateRating(" + id + "," + rating + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			ratingServiceInterface.updateRating(id, rating);

			return "redirect:/rating/list";
		}

		return "/rating/update.html";
	}

	/**
	 * Intercepts the get request of the rating delete
	 * @param id : id of the rating to delete
	 * @param model : defines a holder for model attributes
     * @return Return the rating list template
	 */
	@GetMapping("/rating/delete/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteRating(" + id + "," + model + ")");

		ratingServiceInterface.deleteRating(id);

		return "redirect:/rating/list";
	}
}