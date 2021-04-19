package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rating;

public interface RatingRepositoryInterface {

	public void insertRating(Rating rating);
	
	public Rating selectRating(Integer id);
	
	public ArrayList<Rating> selectRatingList();
	
	public void updatetRating(Integer id, Rating rating);
	
	public void deleteRating(Integer id);
}