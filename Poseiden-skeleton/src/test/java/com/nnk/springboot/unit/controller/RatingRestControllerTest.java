package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.RatingRestController;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RatingRestControllerTest {
	
	private RatingRestController ratingRestController;
	
	@Mock
	private RatingServiceInterface ratingServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Rating Rating;
	
    @Test
    public void createRating_OK() {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	ratingRestController.createRating(Rating, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(1)).createRating(Rating);
    }
	
    @Test
    public void createRating_NOK() {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	ratingRestController.createRating(Rating, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(0)).createRating(Rating);
    }
	
    @Test
    public void readRating() throws JsonProcessingException {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	ratingRestController.readRating(1);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(1)).readRating(1);
    }
	
    @Test
    public void updateRating_OK() {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	ratingRestController.updateRating(1, Rating, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(1)).updateRating(1, Rating);
    }
	
    @Test
    public void updateRating_NOK() {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	ratingRestController.updateRating(1, Rating, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(0)).updateRating(1, Rating);
    }
	
    @Test
    public void deleteRating() {
		
		//GIVEN
    	ratingRestController = new RatingRestController(ratingServiceInterface);

    	//WHEN
    	ratingRestController.deleteRating(1);
		    	
    	//THEN
    	Mockito.verify(ratingServiceInterface, Mockito.times(1)).deleteRating(1);
    }
}