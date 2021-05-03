package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Bid;

/**
 * This interface allows to implement bid repository methods
*/
public interface BidRepositoryInterface {

	/**
	 * Insert a Bid in the Bid table
	 * @param bid : data of the Bid to insert
	 */
	public void insertBid(Bid bid);
	
	/**
	 * Select a Bid in the Bid table
	 * @param id : id of the bid to select
     * @return The bid that was selected
	 */
	public Bid selectBid(Integer id);

	/**
	 * Select the Bid list of the Bid table
     * @return The bid list that was selected
	 */
	public ArrayList<Bid> selectBidList();
	
	/**
	 * Update a Bid in the Bid table
	 * @param id : id of the bid to update
	 * @param bid : data of the Bid to update
	 */
	public void updateBid(Integer id, Bid bid);

	/**
	 * Delete a Bid in the Bid table
	 * @param id : id of the bid to delete
	 */
	public void deleteBid(Integer id);
}