package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Trade;

@Component
public class TradeRepository implements TradeRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("TradeRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public TradeRepository() {
		logger.info("TradeRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertTrade(Trade trade) {
		logger.info("insertTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Trade selectTrade(Integer id) {
		logger.info("selectTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Trade> selectTradeList() {
		logger.info("selectTradeList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetTrade(Integer id, Trade trade) {
		logger.info("updatetTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteTrade(Integer id) {
		logger.info("deleteTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}