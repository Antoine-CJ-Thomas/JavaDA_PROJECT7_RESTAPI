package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Trade;

/**
 * This interface allows to implement trade repository methods
*/
public interface TradeRepositoryInterface {

	/**
	 * Insert a Trade in the Trade table
	 * @param trade : data of the Trade to insert
	 */
	public void insertTrade(Trade trade);
	
	/**
	 * Select a Trade in the Trade table
	 * @param id : id of the Trade to select
     * @return The Trade that was selected
	 */
	public Trade selectTrade(Integer id);

	/**
	 * Select the Trade list of the Trade table
     * @return The Trade list that was selected
	 */
	public ArrayList<Trade> selectTradeList();
	
	/**
	 * Update a Trade in the Trade table
	 * @param id : id of the Trade to update
	 * @param trade : data of the Trade to update
	 */
	public void updateTrade(Integer id, Trade trade);

	/**
	 * Delete a Trade in the Trade table
	 * @param id : id of the Trade to delete
	 */
	public void deleteTrade(Integer id);
}