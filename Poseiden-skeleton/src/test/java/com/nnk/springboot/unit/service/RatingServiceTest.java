package com.nnk.springboot.unit.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repository.RatingRepositoryInterface;
import com.nnk.springboot.service.RatingService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RatingServiceTest {
	
	private RatingService ratingService;
	
	@Mock
	private RatingRepositoryInterface ratingRepositoryInterface;
	
	@Mock
	private Rating rating;
	
    @Test
    public void createRating() {
		
		//GIVEN
    	ratingService = new RatingService(ratingRepositoryInterface);

    	//WHEN
    	ratingService.createRating(rating);
    	
    	//THEN
        verify(ratingRepositoryInterface, Mockito.times(1)).insertRating(rating);
    }
	
    @Test
    public void readRating() {
		
		//GIVEN
    	ratingService = new RatingService(ratingRepositoryInterface);

    	//WHEN
    	ratingService.readRating(1);
    	
    	//THEN
        verify(ratingRepositoryInterface, Mockito.times(1)).selectRating(1);
    }
	
    @Test
    public void readRatingList() {
		
		//GIVEN
    	ratingService = new RatingService(ratingRepositoryInterface);

    	//WHEN
    	ratingService.readRatingList();
    	
    	//THEN
        verify(ratingRepositoryInterface, Mockito.times(1)).selectRatingList();
    }
	
    @Test
    public void updateRating() {
		
		//GIVEN
    	ratingService = new RatingService(ratingRepositoryInterface);

    	//WHEN
    	ratingService.updateRating(1, rating);
    	
    	//THEN
        verify(ratingRepositoryInterface, Mockito.times(1)).updateRating(1, rating);
    }
	
    @Test
    public void deleteRating() {
		
		//GIVEN
    	ratingService = new RatingService(ratingRepositoryInterface);

    	//WHEN
    	ratingService.deleteRating(1);
    	
    	//THEN
        verify(ratingRepositoryInterface, Mockito.times(1)).deleteRating(1);
    }
}
