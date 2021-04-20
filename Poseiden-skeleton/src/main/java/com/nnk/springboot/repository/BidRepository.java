package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.bid;

@Component
public class BidRepository implements BidRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("BidRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public BidRepository() {
		logger.info("BidRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertBid(Bid bid) {
		logger.info("insertBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "bid ("
			
					+ "account,"
					+ "type,"
					+ "bidQuantity,"
					+ "askQuantity,"
					+ "bid,"
				
					+ "ask,"
					+ "benchmark,"
					+ "bidListDate,"
					+ "commentary,"
					+ "security,"
				
					+ "status,"
					+ "trader,"
					+ "book,"
					+ "creationName,"
					+ "creationDate,"
				
					+ "revisionName,"
					+ "revisionDate,"
					+ "dealName,"
					+ "dealType,"
					+ "sourceListId,"
				
					+ "side) "
				
				+ "VALUES ("
			
					+ "'" + bid.getAccount() + "',"
					+ "'" + bid.getType() + "',"
					+ " " + bid.getBidQuantity() + ","
					+ " " + bid.getAskQuantity() + ","
					+ " " + bid.getBid() + ","
				
					+ " " + bid.getAsk() + ","
					+ "'" + bid.getBenchmark() + "',"
					+ "'" + bid.getBidListDate() + "',"
					+ "'" + bid.getCommentary() + "',"
					+ "'" + bid.getSecurity() + "',"
				
					+ "'" + bid.getStatus() + "',"
					+ "'" + bid.getTrader() + "',"
					+ "'" + bid.getBook() + "',"
					+ "'" + bid.getCreationName() + "',"
					+ "'" + bid.getCreationDate() + "',"
				
					+ "'" + bid.getRevisionName() + "',"
					+ "'" + bid.getRevisionDate() + "',"
					+ "'" + bid.getDealName() + "',"
					+ "'" + bid.getDealType() + "',"
					+ "'" + bid.getSourceListId() + "',"
				
					+ "'" + bid.getSide() + "');";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Bid selectBid(Integer id) {
		logger.info("selectBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM bid WHERE Id='" + id + "';";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		Bid bid = new Bid();
		
    	try {

			if (resultSet.next()) {

				bid.setBidListId(resultSet.getInt("Id"));
				
				bid.setAccount(resultSet.getString("account"));
				bid.setType(resultSet.getString("type"));
				bid.setBidQuantity(resultSet.getDouble("bidQuantity"));
				bid.setAskQuantity(resultSet.getDouble("askQuantity"));
				bid.setBid(resultSet.getDouble("bid"));
				
				bid.setAsk(resultSet.getDouble("ask"));
				bid.setBenchmark(resultSet.getString("benchmark"));
				bid.setBidListDate(resultSet.getTimestamp("bidListDate"));
				bid.setCommentary(resultSet.getString("commentary"));
				bid.setSecurity(resultSet.getString("security"));
				
				bid.setStatus(resultSet.getString("status"));
				bid.setTrader(resultSet.getString("trader"));
				bid.setBook(resultSet.getString("book"));
				bid.setCreationName(resultSet.getString("creationName"));
				bid.setCreationDate(resultSet.getTimestamp("creationDate"));
				
				bid.setRevisionName(resultSet.getString("revisionName"));
				bid.setRevisionDate(resultSet.getTimestamp("revisionDate"));
				bid.setDealName(resultSet.getString("dealName"));
				bid.setDealType(resultSet.getString("dealType"));
				bid.setSourceListId(resultSet.getString("sourceListId"));
				
				bid.setSide(resultSet.getString("side"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return bid;
	}

	@Override
	public ArrayList<Bid> selectBidList() {
		logger.info("selectBidList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM bid";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		
    	try {

			if (resultSet.next()) {
				
				bidList.add(new Bid());

				bidList.get(bidList.size()-1).setBidListId(resultSet.getInt("Id"));
				
				bidList.get(bidList.size()-1).setAccount(resultSet.getString("account"));
				bidList.get(bidList.size()-1).setType(resultSet.getString("type"));
				bidList.get(bidList.size()-1).setBidQuantity(resultSet.getDouble("bidList.get(bidList.size()-1)Quantity"));
				bidList.get(bidList.size()-1).setAskQuantity(resultSet.getDouble("askQuantity"));
				bidList.get(bidList.size()-1).setBid(resultSet.getDouble("bidList.get(bidList.size()-1)"));
				
				bidList.get(bidList.size()-1).setAsk(resultSet.getDouble("ask"));
				bidList.get(bidList.size()-1).setBenchmark(resultSet.getString("benchmark"));
				bidList.get(bidList.size()-1).setBidListDate(resultSet.getTimestamp("bidList.get(bidList.size()-1)ListDate"));
				bidList.get(bidList.size()-1).setCommentary(resultSet.getString("commentary"));
				bidList.get(bidList.size()-1).setSecurity(resultSet.getString("security"));
				
				bidList.get(bidList.size()-1).setStatus(resultSet.getString("status"));
				bidList.get(bidList.size()-1).setTrader(resultSet.getString("trader"));
				bidList.get(bidList.size()-1).setBook(resultSet.getString("book"));
				bidList.get(bidList.size()-1).setCreationName(resultSet.getString("creationName"));
				bidList.get(bidList.size()-1).setCreationDate(resultSet.getTimestamp("creationDate"));
				
				bidList.get(bidList.size()-1).setRevisionName(resultSet.getString("revisionName"));
				bidList.get(bidList.size()-1).setRevisionDate(resultSet.getTimestamp("revisionDate"));
				bidList.get(bidList.size()-1).setDealName(resultSet.getString("dealName"));
				bidList.get(bidList.size()-1).setDealType(resultSet.getString("dealType"));
				bidList.get(bidList.size()-1).setSourceListId(resultSet.getString("sourceListId"));
				
				bidList.get(bidList.size()-1).setSide(resultSet.getString("side"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return bidList;
	}

	@Override
	public void updatetBid(Integer id, Bid bid) {
		logger.info("updatetBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "UPDATE bid "
		
			+ "SET "
			
				+ "account=" + "'" + bid.getAccount() + "',"
				+ "type=" + "'" + bid.getType() + "',"
				+ "bidQuantity=" + "" + bid.getBidQuantity() + ","
				+ "askQuantity=" + "" + bid.getAskQuantity() + ","
				+ "bid=" + "" + bid.getBid() + ","
			
				+ "ask=" + "" + bid.getAsk() + ","
				+ "benchmark=" + "'" + bid.getBenchmark() + "',"
				+ "bidListDate=" + "'" + bid.getBidListDate() + "',"
				+ "commentary=" + "'" + bid.getCommentary() + "',"
				+ "security=" + "'" + bid.getSecurity() + "',"
			
				+ "status=" + "'" + bid.getStatus() + "',"
				+ "trader=" + "'" + bid.getTrader() + "',"
				+ "book=" + "'" + bid.getBook() + "',"
				+ "creationName=" + "'" + bid.getCreationName() + "',"
				+ "creationDate=" + "'" + bid.getCreationDate() + "',"
			
				+ "revisionName=" + "'" + bid.getRevisionName() + "',"
				+ "revisionDate=" + "'" + bid.getRevisionDate() + "',"
				+ "dealName=" + "'" + bid.getDealName() + "',"
				+ "dealType=" + "'" + bid.getDealType() + "',"
				+ "sourceListId=" + "'" + bid.getSourceListId() + "',"
			
				+ "side=" + "'" + bid.getSide() + "'"
		
    		+ "WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteBid(Integer id) {
		logger.info("deleteBid");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM bid WHERE Id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}
