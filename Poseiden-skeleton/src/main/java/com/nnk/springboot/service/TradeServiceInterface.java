package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Trade;

/**
 * This interface allows to implement trade service methods
*/
public interface TradeServiceInterface {

	public void createTrade(Trade trade);

	public Trade readTrade(Integer id);

	public ArrayList<Trade> readTradeList();

	public void updateTrade(Integer id, Trade trade);

	public void deleteTrade(Integer id);
}
