package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rating;
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

	public RatingController() {
		logger.info("RatingController()");

		ratingServiceInterface = new RatingService();
	}

	@RequestMapping("/rating/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("ratingList", ratingServiceInterface.readRatingList());

		return "/rating/list.html";
	}

	@GetMapping("/rating/add")
	public String addRatingForm(Rating rating) {
		logger.info("addRatingForm(" + rating + ")");

		return "/rating/add.html";
	}

	@PostMapping("/rating/validate")
	public String validate(@Valid Rating rating, BindingResult bindingResult, Model model) {
		logger.info("validate(" + rating + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			ratingServiceInterface.createRating(rating);

			return "redirect:/rating/list";
		}

		return "/rating/add.html";
	}

	@GetMapping("/rating/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("rating", ratingServiceInterface.readRating(id));

		return "/rating/update.html";
	}

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

	@GetMapping("/rating/delete/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteRating(" + id + "," + model + ")");

		ratingServiceInterface.deleteRating(id);

		return "/redirect:/rating/list";
	}
}