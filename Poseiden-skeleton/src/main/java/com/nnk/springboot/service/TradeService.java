package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repository.TradeRepository;
import com.nnk.springboot.repository.TradeRepositoryInterface;

@Service
public class TradeService implements TradeServiceInterface {

	@Autowired
	private TradeRepositoryInterface tradeRepositoryInterface;

	public TradeService() {
		
		tradeRepositoryInterface = new TradeRepository();
	}

	@Override
	public void createTrade(Trade trade) {
		
		tradeRepositoryInterface.insertTrade(trade);
	}


	@Override
	public Trade readTrade(Integer id) {
		
		return tradeRepositoryInterface.selectTrade(id);
	}


	@Override
	public ArrayList<Trade> readTradeList() {
		
		return tradeRepositoryInterface.selectTradeList();
	}


	@Override
	public void updateTrade(Integer id, Trade trade) {
		
		tradeRepositoryInterface.updatetTrade(id, trade);
	}


	@Override
	public void deleteTrade(Integer id) {
		
		tradeRepositoryInterface.deleteTrade(id);
	}
}