package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Bid;

/**
 * This interface allows to implement bid service methods
*/
public interface BidServiceInterface {

	/**
	 * Create a Bid
	 * @param bid : data of the Bid to create
	 */
	public void createBid(Bid bid);

	/**
	 * Read a Bid
	 * @param id : id of the Bid to read
     * @return The Bid that was read
	 */
	public Bid readBid(Integer id);

	/**
	 * Read the bid list
     * @return The Bid list that was read
	 */
	public ArrayList<Bid> readBidList();
	
	/**
	 * Update a Bid
	 * @param id : id of the Bid to update
	 * @param bid : data of the Bid to update
	 */
	public void updateBid(Integer id, Bid bid);

	/**
	 * Delete a Bid
	 * @param id : id of the Bid to delete
	 */
	public void deleteBid(Integer id);
}
