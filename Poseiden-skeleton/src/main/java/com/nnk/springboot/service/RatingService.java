package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repository.RatingRepository;
import com.nnk.springboot.repository.RatingRepositoryInterface;

/**
 * This class allows to interact with a rating repository
 */
@Service
public class RatingService implements RatingServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private RatingRepositoryInterface ratingRepositoryInterface;

	/**
	 * Creates a new RatingService
	 */
	public RatingService() {
		logger.info("RatingService()");

		ratingRepositoryInterface = new RatingRepository();
	}

	/**
	 * Creates a new RatingService with the specified RatingRepositoryInterface
	 * @param ratingRepositoryInterface : repository that this service will use
	 */
	public RatingService(RatingRepositoryInterface ratingRepositoryInterface) {
		logger.info("RatingService(" + ratingRepositoryInterface + ")");

		this.ratingRepositoryInterface = ratingRepositoryInterface;
	}

	@Override
	public void createRating(Rating rating) {
		logger.info("createRating(" + rating + ")");

		ratingRepositoryInterface.insertRating(rating);
	}

	@Override
	public Rating readRating(Integer id) {
		logger.info("readRating(" + id + ")");

		return ratingRepositoryInterface.selectRating(id);
	}

	@Override
	public ArrayList<Rating> readRatingList() {
		logger.info("readRatingList()");

		return ratingRepositoryInterface.selectRatingList();
	}

	@Override
	public void updateRating(Integer id, Rating rating) {
		logger.info("updateRating(" + id + "," + rating + ")");

		ratingRepositoryInterface.updateRating(id, rating);
	}

	@Override
	public void deleteRating(Integer id) {
		logger.info("deleteRating(" + id + ")");

		ratingRepositoryInterface.deleteRating(id);
	}
}