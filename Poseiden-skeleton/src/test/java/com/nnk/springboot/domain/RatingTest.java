package com.nnk.springboot.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RatingTest {
	
	private Rating rating;
	
    @Test
    public void setAndGetId() {
		
		//GIVEN
    	rating = new Rating();

    	//WHEN
    	rating.setId(1);
    	
    	//THEN
    	Assert.assertTrue(rating.getId() == 1);
    }
	
    @Test
    public void setAndGetMoodysRating() {
		
		//GIVEN
    	rating = new Rating();

    	//WHEN
    	rating.setMoodysRating("MoodysRating");
    	
    	//THEN
    	Assert.assertTrue(rating.getMoodysRating().equals("MoodysRating"));
    }
	
    @Test
    public void setAndGetSandPRating() {
		
		//GIVEN
    	rating = new Rating();

    	//WHEN
    	rating.setSandPRating("SandPRating");
    	
    	//THEN
    	Assert.assertTrue(rating.getSandPRating().equals("SandPRating"));
    }
	
    @Test
    public void setAndGetFitchRating() {
		
		//GIVEN
    	rating = new Rating();

    	//WHEN
    	rating.setFitchRating("FitchRating");
    	
    	//THEN
    	Assert.assertTrue(rating.getFitchRating().equals("FitchRating"));
    }
	
    @Test
    public void setAndGetOrderNumber() {
		
		//GIVEN
    	rating = new Rating();

    	//WHEN
    	rating.setOrderNumber(1);
    	
    	//THEN
    	Assert.assertTrue(rating.getOrderNumber() == 1);
    }
}
