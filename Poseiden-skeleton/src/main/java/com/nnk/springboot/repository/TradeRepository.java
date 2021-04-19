package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Trade;

@Component
public class TradeRepository implements TradeRepositoryInterface {

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public TradeRepository() {
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertTrade(Trade trade) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Trade selectTrade(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Trade> selectTradeList() {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetTrade(Integer id, Trade trade) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteTrade(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}