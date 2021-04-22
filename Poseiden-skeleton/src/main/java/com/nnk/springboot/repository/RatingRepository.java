package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Rating;

/**
 * This class allows to prepare queries for the rating table and send them to the database configured
 */
@Component
public class RatingRepository implements RatingRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public RatingRepository() {
		logger.info("RatingRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertRating(Rating rating) {
		logger.info("insertRating(" + rating + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "rating ("
				
					+ "moodysRating,"
					+ "sandPRating,"
					+ "fitchRating,"
					+ "orderNumber) "
					
				+ "VALUES ("
			
					+ "'" + rating.getMoodysRating() + "',"
					+ "'" + rating.getSandPRating() + "',"
					+ "'" + rating.getFitchRating() + "',"
					+ "'" + rating.getOrderNumber() + "');";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Rating selectRating(Integer id) {
		logger.info("selectRating(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM rating WHERE Id=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		Rating rating = new Rating();
		
    	try {

			if (resultSet.next()) {

				rating.setId(resultSet.getInt("Id"));
				rating.setMoodysRating(resultSet.getString("moodysRating"));
				rating.setSandPRating(resultSet.getString("sandPRating"));
				rating.setFitchRating(resultSet.getString("fitchRating"));
				rating.setOrderNumber(resultSet.getInt("orderNumber"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return rating;
	}

	@Override
	public ArrayList<Rating> selectRatingList() {
		logger.info("selectRatingList()");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM rating";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		
    	try {

    		while (resultSet.next()) {
				
				ratingList.add(new Rating());

				ratingList.get(ratingList.size()-1).setId(resultSet.getInt("Id"));
				ratingList.get(ratingList.size()-1).setMoodysRating(resultSet.getString("moodysRating"));
				ratingList.get(ratingList.size()-1).setSandPRating(resultSet.getString("sandPRating"));
				ratingList.get(ratingList.size()-1).setFitchRating(resultSet.getString("fitchRating"));
				ratingList.get(ratingList.size()-1).setOrderNumber(resultSet.getInt("orderNumber"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return ratingList;
	}

	@Override
	public void updateRating(Integer id, Rating rating) {
		logger.info("updateRating(" + id + "," + rating + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "UPDATE rating "
			
				+ "SET "
				
					+ "moodysRating=" + "'" + rating.getMoodysRating() + "',"
					+ "sandPRating=" + "'" + rating.getSandPRating() + "',"
					+ "fitchRating=" + "'" + rating.getFitchRating() + "',"
					+ "orderNumber=" + "" + rating.getOrderNumber() + " "
		
    			+ "WHERE Id=" + id + ";";
		
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
        		
	}

	@Override
	public void deleteRating(Integer id) {
		logger.info("deleteRating(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM rating WHERE Id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}
}