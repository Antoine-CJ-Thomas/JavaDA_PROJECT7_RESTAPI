package com.nnk.springboot.controller;

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

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BidControllerTest {
	
	private BidController bidController;
	
	@Mock
	private BidServiceInterface bidServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private Bid bid;

	@Mock
	private ArrayList<Bid> bidList;
	
    @Test
    public void home() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bidServiceInterface.readBidList()).thenReturn(bidList);
		    	
    	//THEN
    	Assert.assertTrue(bidController.home(model).equals("/bidList/list.html"));
    }
	
    @Test
    public void addBidForm() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(bidController.addBidForm(bid).equals("/bidList/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(bidController.validate(bid, bindingResult, model).equals("redirect:/bidList/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(bidController.validate(bid, bindingResult, model).equals("/bidList/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bidServiceInterface.readBid(1)).thenReturn(bid);
		    	
    	//THEN
    	Assert.assertTrue(bidController.showUpdateForm(1, model).equals("/bidList/update.html"));
    }
	
    @Test
    public void updateBid_OK() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(bidController.updateBid(1, bid, bindingResult, model).equals("redirect:/bidList/list"));
    }
	
    @Test
    public void updateBid_NOK() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(bidController.updateBid(1, bid, bindingResult, model).equals("/bidList/update.html"));
    }
	
    @Test
    public void deleteBid() {
		
		//GIVEN
    	bidController = new BidController(bidServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(bidController.deleteBid(1, model).equals("redirect:/bidList/list"));
    }
}