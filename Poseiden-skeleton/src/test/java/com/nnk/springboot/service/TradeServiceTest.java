package com.nnk.springboot.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repository.TradeRepositoryInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {
	
	private TradeService tradeService;
	
	@Mock
	private TradeRepositoryInterface tradeRepositoryInterface;
	
	@Mock
	private Trade trade;
	
    @Test
    public void createTrade() {
		
		//GIVEN
    	tradeService = new TradeService(tradeRepositoryInterface);

    	//WHEN
    	tradeService.createTrade(trade);
    	
    	//THEN
        verify(tradeRepositoryInterface, Mockito.times(1)).insertTrade(trade);
    }
	
    @Test
    public void readTrade() {
		
		//GIVEN
    	tradeService = new TradeService(tradeRepositoryInterface);

    	//WHEN
    	tradeService.readTrade(1);
    	
    	//THEN
        verify(tradeRepositoryInterface, Mockito.times(1)).selectTrade(1);
    }
	
    @Test
    public void readTradeList() {
		
		//GIVEN
    	tradeService = new TradeService(tradeRepositoryInterface);

    	//WHEN
    	tradeService.readTradeList();
    	
    	//THEN
        verify(tradeRepositoryInterface, Mockito.times(1)).selectTradeList();
    }
	
    @Test
    public void updateTrade() {
		
		//GIVEN
    	tradeService = new TradeService(tradeRepositoryInterface);

    	//WHEN
    	tradeService.updateTrade(1, trade);
    	
    	//THEN
        verify(tradeRepositoryInterface, Mockito.times(1)).updateTrade(1, trade);
    }
	
    @Test
    public void deleteTrade() {
		
		//GIVEN
    	tradeService = new TradeService(tradeRepositoryInterface);

    	//WHEN
    	tradeService.deleteTrade(1);
    	
    	//THEN
        verify(tradeRepositoryInterface, Mockito.times(1)).deleteTrade(1);
    }
}
