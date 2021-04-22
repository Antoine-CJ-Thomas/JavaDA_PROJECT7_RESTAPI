package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Trade;

/**
 * This interface allows to implement trade repository methods
*/
public interface TradeRepositoryInterface {

	public void insertTrade(Trade trade);
	
	public Trade selectTrade(Integer id);
	
	public ArrayList<Trade> selectTradeList();
	
	public void updateTrade(Integer id, Trade trade);
	
	public void deleteTrade(Integer id);
}