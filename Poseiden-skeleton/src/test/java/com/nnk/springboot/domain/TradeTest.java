package com.nnk.springboot.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TradeTest {
	
	private Trade trade;
	
    @Test
    public void setAndGetTradeId() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setTradeId(1);
    	
    	//THEN
    	Assert.assertTrue(trade.getTradeId() == 1);
    }
	
    @Test
    public void setAndGetAccount() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setAccount("Account");
    	
    	//THEN
    	Assert.assertTrue(trade.getAccount().equals("Account"));
    }
	
    @Test
    public void setAndGetType() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setType("Type");
    	
    	//THEN
    	Assert.assertTrue(trade.getType().equals("Type"));
    }
	
    @Test
    public void setAndGetBuyQuantity() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setBuyQuantity(10.0);
    	
    	//THEN
    	Assert.assertTrue(trade.getBuyQuantity() == 10.0);
    }
	
    @Test
    public void setAndGetSellQuantity() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setSellQuantity(10.0);
    	
    	//THEN
    	Assert.assertTrue(trade.getSellQuantity() == 10.0);
    }
	
    @Test
    public void setAndGetBuyPrice() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setBuyPrice(10.0);
    	
    	//THEN
    	Assert.assertTrue(trade.getBuyPrice() == 10.0);
    }
	
    @Test
    public void setAndGetSellPrice() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setSellPrice(10.0);
    	
    	//THEN
    	Assert.assertTrue(trade.getSellPrice() == 10.0);
    }
	
    @Test
    public void setAndGetBenchmark() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setBenchmark("Benchmark");
    	
    	//THEN
    	Assert.assertTrue(trade.getBenchmark().equals("Benchmark"));
    }
/*	
    @Test
    public void setAndGetTradeDate() {
    	
    }
*/  
	
    @Test
    public void setAndGetSecurity() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setSecurity("Security");
    	
    	//THEN
    	Assert.assertTrue(trade.getSecurity().equals("Security"));
    } 
	
    @Test
    public void setAndGetStatus() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setStatus("Status");
    	
    	//THEN
    	Assert.assertTrue(trade.getStatus().equals("Status"));
    }
	
    @Test
    public void setAndGetTrader() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setTrader("Trader");
    	
    	//THEN
    	Assert.assertTrue(trade.getTrader().equals("Trader"));
    }
	
    @Test
    public void setAndGetBook() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setBook("Book");
    	
    	//THEN
    	Assert.assertTrue(trade.getBook().equals("Book"));
    }
	
    @Test
    public void setAndGetCreationName() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setCreationName("CreationName");
    	
    	//THEN
    	Assert.assertTrue(trade.getCreationName().equals("CreationName"));
    }
	
    @Test
    public void setAndGetRevisionName() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setRevisionName("RevisionName");
    	
    	//THEN
    	Assert.assertTrue(trade.getRevisionName().equals("RevisionName"));
    }
/*	
    @Test
    public void setAndGetRevisionDate() {
    	
    }
*/  
	
    @Test
    public void setAndGetDealName() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setDealName("DealName");
    	
    	//THEN
    	Assert.assertTrue(trade.getDealName().equals("DealName"));
    }
	
    @Test
    public void setAndGetDealType() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setDealType("DealType");
    	
    	//THEN
    	Assert.assertTrue(trade.getDealType().equals("DealType"));
    }
	
    @Test
    public void setAndGetSourceListId() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setSourceListId("SourceListId");
    	
    	//THEN
    	Assert.assertTrue(trade.getSourceListId().equals("SourceListId"));
    }
	
    @Test
    public void setAndGetSide() {
		
		//GIVEN
    	trade = new Trade();

    	//WHEN
    	trade.setSide("Side");
    	
    	//THEN
    	Assert.assertTrue(trade.getSide().equals("Side"));
    }
}
