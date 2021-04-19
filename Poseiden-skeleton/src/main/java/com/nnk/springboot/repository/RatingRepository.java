package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Rating;

@Component
public class RatingRepository implements RatingRepositoryInterface {

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public RatingRepository() {
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertRating(Rating rating) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Rating selectRating(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Rating> selectRatingList() {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetRating(Integer id, Rating rating) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
        		
	}

	@Override
	public void deleteRating(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}