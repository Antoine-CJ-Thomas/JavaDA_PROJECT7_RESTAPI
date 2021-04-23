package com.nnk.springboot.domain;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BidTest {
	
	private Bid bid;
	
    @Test
    public void setAndGetBidListId() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setBidListId(1);
    	
    	//THEN
    	Assert.assertTrue(bid.getBidListId() == 1);
    }
	
    @Test
    public void setAndGetAccount() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setAccount("Account");
    	
    	//THEN
    	Assert.assertTrue(bid.getAccount().equals("Account"));
    }
	
    @Test
    public void setAndGetType() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setType("Type");
    	
    	//THEN
    	Assert.assertTrue(bid.getType().equals("Type"));
    }
	
    @Test
    public void setAndGetBidQuantity() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setBidQuantity(10.0);
    	
    	//THEN
    	Assert.assertTrue(bid.getBidQuantity() == 10.0);
    }
	
    @Test
    public void setAndGetAskQuantity() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setAskQuantity(10.0);
    	
    	//THEN
    	Assert.assertTrue(bid.getAskQuantity() == 10.0);
    }
	
    @Test
    public void setAndGetBid() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setBid(10.0);
    	
    	//THEN
    	Assert.assertTrue(bid.getBid() == 10.0);
    }
	
    @Test
    public void setAndGetAsk() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setAsk(10.0);
    	
    	//THEN
    	Assert.assertTrue(bid.getAsk() == 10.0);
    }
	
    @Test
    public void setAndGetBenchmark() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setBenchmark("Benchmark");
    	
    	//THEN
    	Assert.assertTrue(bid.getBenchmark().equals("Benchmark"));
    }
	
    @Test
    public void setAndGetbidListDate() {
		
		//GIVEN
		bid = new Bid();
    	Timestamp bidListDate = new Timestamp(0);

    	//WHEN
    	bid.setBidListDate(bidListDate);
    	
    	//THEN
    	Assert.assertTrue(bid.getBidListDate() == bidListDate);
    }
    
    @Test
    public void setAndGetCommentary() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setCommentary("Commentary");
    	
    	//THEN
    	Assert.assertTrue(bid.getCommentary().equals("Commentary"));
    }
	
    @Test
    public void setAndGetSecurity() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setSecurity("Security");
    	
    	//THEN
    	Assert.assertTrue(bid.getSecurity().equals("Security"));
    }
	
    @Test
    public void setAndGetStatus() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setStatus("Status");
    	
    	//THEN
    	Assert.assertTrue(bid.getStatus().equals("Status"));
    }
	
    @Test
    public void setAndGetTrader() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setTrader("Trader");
    	
    	//THEN
    	Assert.assertTrue(bid.getTrader().equals("Trader"));
    }
	
    @Test
    public void setAndGetBook() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setBook("Book");
    	
    	//THEN
    	Assert.assertTrue(bid.getBook().equals("Book"));
    }
	
    @Test
    public void setAndGetCreationName() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setCreationName("CreationName");
    	
    	//THEN
    	Assert.assertTrue(bid.getCreationName().equals("CreationName"));
    }
	
    @Test
    public void setAndCreationDate() {
		
		//GIVEN
		bid = new Bid();
    	Timestamp creationDate = new Timestamp(0);

    	//WHEN
    	bid.setCreationDate(creationDate);
    	
    	//THEN
    	Assert.assertTrue(bid.getCreationDate() == creationDate);
    }  
	
    @Test
    public void setAndGetRevisionName() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setRevisionName("RevisionName");
    	
    	//THEN
    	Assert.assertTrue(bid.getRevisionName().equals("RevisionName"));
    }
	
    @Test
    public void setAndRevisionDate() {
		
		//GIVEN
		bid = new Bid();
    	Timestamp revisionDate = new Timestamp(0);

    	//WHEN
    	bid.setRevisionDate(revisionDate);
    	
    	//THEN
    	Assert.assertTrue(bid.getRevisionDate() == revisionDate);
    }   
	
    @Test
    public void setAndGetDealName() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setDealName("DealName");
    	
    	//THEN
    	Assert.assertTrue(bid.getDealName().equals("DealName"));
    }
	
    @Test
    public void setAndGetDealType() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setDealType("DealType");
    	
    	//THEN
    	Assert.assertTrue(bid.getDealType().equals("DealType"));
    }
	
    @Test
    public void setAndGetSourceListId() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setSourceListId("SourceListId");
    	
    	//THEN
    	Assert.assertTrue(bid.getSourceListId().equals("SourceListId"));
    }
	
    @Test
    public void setAndGetSide() {
		
		//GIVEN
		bid = new Bid();

    	//WHEN
    	bid.setSide("Side");
    	
    	//THEN
    	Assert.assertTrue(bid.getSide().equals("Side"));
    }
}
