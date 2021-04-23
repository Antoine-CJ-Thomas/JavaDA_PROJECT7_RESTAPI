package com.nnk.springboot.unit.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repository.TradeRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TradeRepositoryTest {
	
	private TradeRepository tradeRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private Trade trade;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertTrade() {
		
		//GIVEN
    	tradeRepository = new TradeRepository(dataBaseConfigurationInterface);

    	//WHEN
    	tradeRepository.insertTrade(trade);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectTrade() {
		
		//GIVEN
    	tradeRepository = new TradeRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		tradeRepository.selectTrade(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectTradeList() {
		
		//GIVEN
    	tradeRepository = new TradeRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		tradeRepository.selectTradeList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateTrade() {
		
		//GIVEN
    	tradeRepository = new TradeRepository(dataBaseConfigurationInterface);

    	//WHEN
    	tradeRepository.updateTrade(1, trade);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteTrade() {
		
		//GIVEN
    	tradeRepository = new TradeRepository(dataBaseConfigurationInterface);

    	//WHEN
    	tradeRepository.deleteTrade(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
}