package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Rating;

@Component
public class RatingRepository implements RatingRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("RatingRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public RatingRepository() {
		logger.info("RatingRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertRating(Rating rating) {
		logger.info("insertRating");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Rating selectRating(Integer id) {
		logger.info("selectRating");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Rating> selectRatingList() {
		logger.info("selectRatingList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetRating(Integer id, Rating rating) {
		logger.info("updatetRating");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
        		
	}

	@Override
	public void deleteRating(Integer id) {
		logger.info("deleteRating");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}