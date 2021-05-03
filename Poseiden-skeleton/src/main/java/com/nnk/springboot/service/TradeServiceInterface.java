package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Trade;

/**
 * This interface allows to implement trade service methods
*/
public interface TradeServiceInterface {
	
	/**
	 * Create a Trade
	 * @param trade : data of the Trade to create
	 */
	public void createTrade(Trade trade);

	/**
	 * Read a Trade
	 * @param id : id of the Trade to read
     * @return The Trade that was read
	 */
	public Trade readTrade(Integer id);

	/**
	 * Read the Trade list
     * @return The Trade list that was read
	 */
	public ArrayList<Trade> readTradeList();
	
	/**
	 * Update a Trade
	 * @param id : id of the Trade to update
	 * @param trade : data of the Trade to update
	 */
	public void updateTrade(Integer id, Trade trade);
	
	/**
	 * Delete a Trade
	 * @param id : id of the Trade to delete
	 */
	public void deleteTrade(Integer id);
}
