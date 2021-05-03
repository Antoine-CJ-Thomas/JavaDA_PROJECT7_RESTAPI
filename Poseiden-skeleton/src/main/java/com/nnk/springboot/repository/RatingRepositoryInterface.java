package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rating;

/**
 * This interface allows to implement rating repository methods
*/
public interface RatingRepositoryInterface {

	/**
	 * Insert a Rating in the Rating table
	 * @param rating : data of the Rating to insert
	 */
	public void insertRating(Rating rating);
	
	/**
	 * Select a Rating in the Rating table
	 * @param id : id of the Rating to select
     * @return The Rating that was selected
	 */
	public Rating selectRating(Integer id);

	/**
	 * Select the Rating list of the Rating table
     * @return The Rating list that was selected
	 */
	public ArrayList<Rating> selectRatingList();
	
	/**
	 * Update a Rating in the Rating table
	 * @param id : id of the Rating to update
	 * @param rating : data of the Rating to update
	 */
	public void updateRating(Integer id, Rating rating);

	/**
	 * Delete a Rating in the Rating table
	 * @param id : id of the Rating to delete
	 */
	public void deleteRating(Integer id);
}