package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rating;

public interface RatingServiceInterface {

	public void createRating(Rating rating);

	public Rating readRating(Integer id);

	public ArrayList<Rating> readRatingList();

	public void updateRating(Integer id, Rating rating);

	public void deleteRating(Integer id);
}
