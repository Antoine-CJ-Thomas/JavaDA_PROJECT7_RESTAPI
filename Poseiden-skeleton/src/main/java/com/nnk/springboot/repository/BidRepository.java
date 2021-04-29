package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Bid;

/**
 * This class allows to prepare queries for the bid table and send them to the database configured
 */
@Component
public class BidRepository implements BidRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;

	/**
	 * Creates a new BidRepository
	 */
	public BidRepository() {
		logger.info("BidRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	/**
	 * Creates a new BidRepository with the specified DataBaseConfigurationInterface
	 * @param dataBaseConfigurationInterface : database configuration that this repository will use
	 */
	public BidRepository(DataBaseConfigurationInterface dataBaseConfigurationInterface) {
		logger.info("BidRepository(" + dataBaseConfigurationInterface + ")");

		this.dataBaseConfigurationInterface = dataBaseConfigurationInterface;
	}

	@Override
	public void insertBid(Bid bid) {
		logger.info("insertBid(" + bid + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "bidlist ("
			
					+ "account,"
					+ "type,"
					+ "bidQuantity)"
				
				+ "VALUES ("
			
					+ "'" + bid.getAccount() + "',"
					+ "'" + bid.getType() + "',"
					+ " " + bid.getBidQuantity() + ");";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Bid selectBid(Integer id) {
		logger.info("selectBid(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM bidlist WHERE BidListId='" + id + "';";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);

		Bid bid = null;
		
    	try {

			if (resultSet.next()) {
				
				bid = new Bid();

				bid.setBidListId(resultSet.getInt("BidListId"));
				
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
		logger.info("selectBidList()");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM bidlist";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		
    	try {

			while (resultSet.next()) {
				
				Bid bid = new Bid();

				bid.setBidListId(resultSet.getInt("BidListId"));
				
				bid.setBidListId(resultSet.getInt("BidListId"));
				
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
				
				bidList.add(bid);
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
	public void updateBid(Integer id, Bid bid) {
		logger.info("updateBid(" + id + "," + bid + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "UPDATE bidlist "
		
			+ "SET "
			
				+ "account=" + "'" + bid.getAccount() + "',"
				+ "type=" + "'" + bid.getType() + "',"
				+ "bidQuantity=" + "" + bid.getBidQuantity() + ""
		
    		+ "WHERE BidListId=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteBid(Integer id) {
		logger.info("deleteBid(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM bidlist WHERE BidListId= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}