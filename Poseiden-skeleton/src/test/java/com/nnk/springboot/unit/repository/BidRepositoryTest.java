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
import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repository.BidRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BidRepositoryTest {
	
	private BidRepository bidRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private Bid bid;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertBid() {
		
		//GIVEN
    	bidRepository = new BidRepository(dataBaseConfigurationInterface);

    	//WHEN
    	bidRepository.insertBid(bid);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectBid() {
		
		//GIVEN
    	bidRepository = new BidRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
    	bidRepository.selectBid(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectBidList() {
		
		//GIVEN
    	bidRepository = new BidRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
    	bidRepository.selectBidList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateBid() {
		
		//GIVEN
    	bidRepository = new BidRepository(dataBaseConfigurationInterface);

    	//WHEN
    	bidRepository.updateBid(1, bid);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteBid() {
		
		//GIVEN
    	bidRepository = new BidRepository(dataBaseConfigurationInterface);

    	//WHEN
    	bidRepository.deleteBid(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
}
