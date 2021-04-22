package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repository.TradeRepository;
import com.nnk.springboot.repository.TradeRepositoryInterface;

@Service
public class TradeService implements TradeServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private TradeRepositoryInterface tradeRepositoryInterface;

	public TradeService() {
		logger.info("TradeService()");

		tradeRepositoryInterface = new TradeRepository();
	}

	@Override
	public void createTrade(Trade trade) {
		logger.info("createTrade(" + trade + ")");

		tradeRepositoryInterface.insertTrade(trade);
	}

	@Override
	public Trade readTrade(Integer id) {
		logger.info("readTrade(" + id + ")");

		return tradeRepositoryInterface.selectTrade(id);
	}

	@Override
	public ArrayList<Trade> readTradeList() {
		logger.info("readTradeList()");

		return tradeRepositoryInterface.selectTradeList();
	}

	@Override
	public void updateTrade(Integer id, Trade trade) {
		logger.info("updateTrade(" + id + "," + trade + ")");

		tradeRepositoryInterface.updateTrade(id, trade);
	}

	@Override
	public void deleteTrade(Integer id) {
		logger.info("deleteTrade(" + id + ")");

		tradeRepositoryInterface.deleteTrade(id);
	}
}