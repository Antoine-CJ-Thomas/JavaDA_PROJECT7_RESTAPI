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

import com.nnk.springboot.controller.TradeController;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TradeControllerTest {
	
	private TradeController tradeController;
	
	@Mock
	private TradeServiceInterface tradeServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private Trade trade;

	@Mock
	private ArrayList<Trade> tradeList;
	
    @Test
    public void home() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(tradeServiceInterface.readTradeList()).thenReturn(tradeList);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.home(model).equals("/trade/list.html"));
    }
	
    @Test
    public void addTradeForm() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(tradeController.addTradeForm(trade).equals("/trade/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.validate(trade, bindingResult, model).equals("redirect:/trade/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.validate(trade, bindingResult, model).equals("/trade/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(tradeServiceInterface.readTrade(1)).thenReturn(trade);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.showUpdateForm(1, model).equals("/trade/update.html"));
    }
	
    @Test
    public void updateTrade_OK() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.updateTrade(1, trade, bindingResult, model).equals("redirect:/trade/list"));
    }
	
    @Test
    public void updateTrade_NOK() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(tradeController.updateTrade(1, trade, bindingResult, model).equals("/trade/update.html"));
    }
	
    @Test
    public void deleteTrade() {
		
		//GIVEN
    	tradeController = new TradeController(tradeServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(tradeController.deleteTrade(1, model).equals("redirect:/trade/list"));
    }
}