package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Bid;

@Component
public class BidRepository implements BidRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("BidRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public BidRepository() {
		logger.info("BidRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertBid(Bid bid) {
		logger.info("insertBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Bid selectBid(Integer id) {
		logger.info("selectBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Bid> selectBidList() {
		logger.info("selectBidList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetBid(Integer id, Bid bid) {
		logger.info("updatetBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteBid(Integer id) {
		logger.info("deleteBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}
