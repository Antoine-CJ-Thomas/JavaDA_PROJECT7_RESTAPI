package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import com.nnk.springboot.service.RatingServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class allows to intercept rating REST requests
 */
@RestController
public class RatingRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private RatingServiceInterface ratingServiceInterface;
	
	/**
	 * Creates a new RatingRestController
	 */
	public RatingRestController() {
		logger.info("ratingController()");

		ratingServiceInterface = new RatingService();
	}

	/**
	 * Creates a new RatingRestController with the specified RatingServiceInterface
	 * @param ratingServiceInterface : service that this controller will use
	 */
	public RatingRestController(RatingServiceInterface ratingServiceInterface) {
		logger.info("ratingController(" + ratingServiceInterface + ")");

		this.ratingServiceInterface = ratingServiceInterface;
	}

	/**
	 * Intercepts the creating request of a rating
	 * @param rating : data of the rating to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/rating/create")
	public void createRating(@Valid Rating rating, BindingResult bindingResult) {
		logger.info("createRating(" + rating + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			ratingServiceInterface.createRating(rating);
		}
	}

	/**
	 * Intercepts the getting request of a rating
	 * @param id : id of the rating to read
     * @return Return the rating (JSon)
	 */
	@GetMapping("/rating/read")
	public String readRating(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readRating(" + id + ")");

        return objectMapper.writeValueAsString(ratingServiceInterface.readRating(id));
	}

	/**
	 * Intercepts the updating request of a rating
	 * @param id : id of the rating to update
	 * @param rating : data of the rating to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/rating/update")
	public void updateRating(@RequestParam("id") Integer id, @Valid Rating rating, BindingResult bindingResult) {
		logger.info("updateRating(" + id + "," + rating + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			ratingServiceInterface.updateRating(id, rating);
		}
	}

	/**
	 * Intercepts the deleting request of a rating
	 * @param id : id of the rating to delete
	 */
	@DeleteMapping("/rating/delete")
	public void deleteRating(@RequestParam("id") Integer id) {
		logger.info("deleteRating(" + id + ")");
		
		ratingServiceInterface.deleteRating(id);
	}
}