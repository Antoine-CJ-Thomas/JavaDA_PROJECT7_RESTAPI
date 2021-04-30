package com.nnk.springboot.unit.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nnk.springboot.controller.RatingController;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.LoginServiceInterface;
import com.nnk.springboot.service.RatingServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RatingControllerTest {
	
	private RatingController RatingController;
	
	@Mock
	private RatingServiceInterface ratingServiceInterface;
	
	@Mock
	private LoginServiceInterface loginServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private Rating rating;

	@Mock
	private ArrayList<Rating> ratingList;
	
    @Test
    public void home() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(ratingServiceInterface.readRatingList()).thenReturn(ratingList);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.home(model).equals("/rating/list.html"));
    }
	
    @Test
    public void addRatingForm() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(RatingController.addRatingForm(rating).equals("/rating/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.validate(rating, bindingResult, model).equals("redirect:/rating/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.validate(rating, bindingResult, model).equals("/rating/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(ratingServiceInterface.readRating(1)).thenReturn(rating);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.showUpdateForm(1, model).equals("/rating/update.html"));
    }
	
    @Test
    public void updateRating_OK() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.updateRating(1, rating, bindingResult, model).equals("redirect:/rating/list"));
    }
	
    @Test
    public void updateRating_NOK() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(RatingController.updateRating(1, rating, bindingResult, model).equals("/rating/update.html"));
    }
	
    @Test
    public void deleteRating() {
		
		//GIVEN
    	RatingController = new RatingController(ratingServiceInterface, loginServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(RatingController.deleteRating(1, model).equals("redirect:/rating/list"));
    }
}