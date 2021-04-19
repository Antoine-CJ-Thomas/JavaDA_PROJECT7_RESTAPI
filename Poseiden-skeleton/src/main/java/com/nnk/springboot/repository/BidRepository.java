package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Bid;

@Component
public class BidRepository implements BidRepositoryInterface {

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public BidRepository() {
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertBid(Bid bid) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Bid selectBid(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Bid> selectBidList() {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetBid(Integer id, Bid bid) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteBid(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}
