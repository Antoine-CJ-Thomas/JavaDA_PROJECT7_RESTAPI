package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rating;

/**
 * This interface allows to implement rating service methods
*/
public interface RatingServiceInterface {
	
	/**
	 * Create a Rating
	 * @param rating : data of the Rating to create
	 */
	public void createRating(Rating rating);
	
	/**
	 * Read a Rating
	 * @param id : id of the Rating to read
     * @return The Rating that was read
	 */
	public Rating readRating(Integer id);
	
	/**
	 * Read the Rating list
     * @return The Rating list that was read
	 */
	public ArrayList<Rating> readRatingList();
	
	/**
	 * Update a Rating
	 * @param id : id of the Rating to update
	 * @param rating : data of the Rating to update
	 */
	public void updateRating(Integer id, Rating rating);
	
	/**
	 * Delete a Rating
	 * @param id : id of the Rating to delete
	 */
	public void deleteRating(Integer id);
}
