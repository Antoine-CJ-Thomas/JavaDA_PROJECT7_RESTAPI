package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.TradeRestController;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TradeRestControllerTest {
	
	private TradeRestController tradeRestController;
	
	@Mock
	private TradeServiceInterface tradeServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Trade trade;
	
    @Test
    public void createTrade_OK() {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	tradeRestController.createTrade(trade, bindingResult);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(1)).createTrade(trade);
    }
	
    @Test
    public void createTrade_NOK() {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	tradeRestController.createTrade(trade, bindingResult);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(0)).createTrade(trade);
    }
	
    @Test
    public void readTrade() throws JsonProcessingException {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	tradeRestController.readTrade(1);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(1)).readTrade(1);
    }
	
    @Test
    public void updateTrade_OK() {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	tradeRestController.updateTrade(1, trade, bindingResult);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(1)).updateTrade(1, trade);
    }
	
    @Test
    public void updateTrade_NOK() {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	tradeRestController.updateTrade(1, trade, bindingResult);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(0)).updateTrade(1, trade);
    }
	
    @Test
    public void deleteTrade() {
		
		//GIVEN
    	tradeRestController = new TradeRestController(tradeServiceInterface);

    	//WHEN
    	tradeRestController.deleteTrade(1);
		    	
    	//THEN
    	Mockito.verify(tradeServiceInterface, Mockito.times(1)).deleteTrade(1);
    }
}