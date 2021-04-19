package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repository.RatingRepository;
import com.nnk.springboot.repository.RatingRepositoryInterface;

@Service
public class RatingService implements RatingServiceInterface {

	@Autowired
	private RatingRepositoryInterface ratingRepositoryInterface;

	public RatingService() {
		
		ratingRepositoryInterface = new RatingRepository();
	}

	@Override
	public void createRating(Rating rating) {
		
		ratingRepositoryInterface.insertRating(rating);
	}


	@Override
	public Rating readRating(Integer id) {
		
		return ratingRepositoryInterface.selectRating(id);
	}


	@Override
	public ArrayList<Rating> readRatingList() {
		
		return ratingRepositoryInterface.selectRatingList();
	}


	@Override
	public void updateRating(Integer id, Rating rating) {
		
		ratingRepositoryInterface.updatetRating(id, rating);
	}


	@Override
	public void deleteRating(Integer id) {
		
		ratingRepositoryInterface.deleteRating(id);
	}
}
