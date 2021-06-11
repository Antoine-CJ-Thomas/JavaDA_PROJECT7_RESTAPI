package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.BidRestController;
import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BidRestControllerTest {
	
	private BidRestController bidRestController;
	
	@Mock
	private BidServiceInterface bidServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Bid bid;
	
    @Test
    public void createBid_OK() {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	bidRestController.createBid(bid, bindingResult);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(1)).createBid(bid);
    }
	
    @Test
    public void createBid_NOK() {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	bidRestController.createBid(bid, bindingResult);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(0)).createBid(bid);
    }
	
    @Test
    public void readBid() throws JsonProcessingException {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	bidRestController.readBid(1);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(1)).readBid(1);
    }
	
    @Test
    public void updateBid_OK() {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	bidRestController.updateBid(1, bid, bindingResult);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(1)).updateBid(1, bid);
    }
	
    @Test
    public void updateBid_NOK() {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	bidRestController.updateBid(1, bid, bindingResult);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(0)).updateBid(1, bid);
    }
	
    @Test
    public void deleteBid() {
		
		//GIVEN
    	bidRestController = new BidRestController(bidServiceInterface);

    	//WHEN
    	bidRestController.deleteBid(1);
		    	
    	//THEN
    	Mockito.verify(bidServiceInterface, Mockito.times(1)).deleteBid(1);
    }
}