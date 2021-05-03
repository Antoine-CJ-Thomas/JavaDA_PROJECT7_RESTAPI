package com.nnk.springboot.unit.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repository.BidRepositoryInterface;
import com.nnk.springboot.service.BidService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BidServiceTest {
	
	private BidService bidService;
	
	@Mock
	private BidRepositoryInterface bidRepositoryInterface;
	
	@Mock
	private Bid bid;
	
    @Test
    public void createBid() {
		
		//GIVEN
    	bidService = new BidService(bidRepositoryInterface);

    	//WHEN
    	bidService.createBid(bid);
    	
    	//THEN
        verify(bidRepositoryInterface, Mockito.times(1)).insertBid(bid);
    }
	
    @Test
    public void readBid() {
		
		//GIVEN
    	bidService = new BidService(bidRepositoryInterface);
    	
    	//WHEN
    	bidService.readBid(1);
    	
    	//THEN
        verify(bidRepositoryInterface, Mockito.times(1)).selectBid(1);
    }
	
    @Test
    public void readBidList() {
		
		//GIVEN
    	bidService = new BidService(bidRepositoryInterface);
    	
    	//WHEN
    	bidService.readBidList();
    	
    	//THEN
        verify(bidRepositoryInterface, Mockito.times(1)).selectBidList();
    }
	
    @Test
    public void updateBid() {
		
		//GIVEN
    	bidService = new BidService(bidRepositoryInterface);
    	
    	//WHEN
    	bidService.updateBid(1, bid);
    	
    	//THEN
        verify(bidRepositoryInterface, Mockito.times(1)).updateBid(1, bid);
    }
	
    @Test
    public void deleteBid() {
		
		//GIVEN
    	bidService = new BidService(bidRepositoryInterface);
    	
    	//WHEN
    	bidService.deleteBid(1);
    	
    	//THEN
        verify(bidRepositoryInterface, Mockito.times(1)).deleteBid(1);
    }
}
