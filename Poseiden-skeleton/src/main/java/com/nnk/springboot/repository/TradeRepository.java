package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Trade;

/**
 * This class allows to prepare queries for the trade table and send them to the database configured
 */
@Component
public class TradeRepository implements TradeRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public TradeRepository() {
		logger.info("TradeRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertTrade(Trade trade) {
		logger.info("insertTrade(" + trade + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "trade ("
							
					+ "account,"
					+ "type,"
					+ "buyQuantity) "
				
				+ "VALUES ("
			
					+ "'" + trade.getAccount() + "',"
					+ "'" + trade.getType() + "',"
					+ " " + trade.getBuyQuantity() + ");";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public Trade selectTrade(Integer id) {
		logger.info("selectTrade(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "SELECT * FROM trade WHERE TradeId=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		Trade trade = new Trade();
		
    	try {

			if (resultSet.next()) {

				trade.setTradeId(resultSet.getInt("TradeId"));
				
				trade.setAccount(resultSet.getString("account"));
				trade.setType(resultSet.getString("type"));
				trade.setBuyQuantity(resultSet.getDouble("buyQuantity"));
				trade.setSellQuantity(resultSet.getDouble("sellQuantity"));
				trade.setBuyPrice(resultSet.getDouble("buyPrice"));
				
				trade.setSellPrice(resultSet.getDouble("sellPrice"));
				trade.setTradeDate(resultSet.getTimestamp("tradeDate"));
				trade.setSecurity(resultSet.getString("security"));
				trade.setStatus(resultSet.getString("status"));
				trade.setTrader(resultSet.getString("trader"));
				
				trade.setBenchmark(resultSet.getString("benchmark"));
				trade.setBook(resultSet.getString("book"));
				trade.setCreationName(resultSet.getString("creationName"));
				trade.setCreationDate(resultSet.getTimestamp("creationDate"));
				trade.setRevisionName(resultSet.getString("revisionName"));
				
				trade.setRevisionDate(resultSet.getTimestamp("revisionDate"));
				trade.setDealName(resultSet.getString("dealName"));
				trade.setDealType(resultSet.getString("dealType"));
				trade.setSourceListId(resultSet.getString("sourceListId"));
				trade.setSide(resultSet.getString("side"));
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
        
		return trade;
	}

	@Override
	public ArrayList<Trade> selectTradeList() {
		logger.info("selectTradeList()");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "SELECT * FROM trade";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Trade> tradeList = new ArrayList<Trade>();
		
    	try {

    		while (resultSet.next()) {
				
				tradeList.add(new Trade());

				tradeList.get(tradeList.size()-1).setTradeId(resultSet.getInt("TradeId"));
				
				tradeList.get(tradeList.size()-1).setAccount(resultSet.getString("account"));
				tradeList.get(tradeList.size()-1).setType(resultSet.getString("type"));
				tradeList.get(tradeList.size()-1).setBuyQuantity(resultSet.getDouble("buyQuantity"));
				tradeList.get(tradeList.size()-1).setSellQuantity(resultSet.getDouble("sellQuantity"));
				tradeList.get(tradeList.size()-1).setBuyPrice(resultSet.getDouble("buyPrice"));
				
				tradeList.get(tradeList.size()-1).setSellPrice(resultSet.getDouble("sellPrice"));
				tradeList.get(tradeList.size()-1).setTradeDate(resultSet.getTimestamp("tradeDate"));
				tradeList.get(tradeList.size()-1).setSecurity(resultSet.getString("security"));
				tradeList.get(tradeList.size()-1).setStatus(resultSet.getString("status"));
				tradeList.get(tradeList.size()-1).setTrader(resultSet.getString("trader"));
				
				tradeList.get(tradeList.size()-1).setBenchmark(resultSet.getString("benchmark"));
				tradeList.get(tradeList.size()-1).setBook(resultSet.getString("book"));
				tradeList.get(tradeList.size()-1).setCreationName(resultSet.getString("creationName"));
				tradeList.get(tradeList.size()-1).setCreationDate(resultSet.getTimestamp("creationDate"));
				tradeList.get(tradeList.size()-1).setRevisionName(resultSet.getString("revisionName"));
				
				tradeList.get(tradeList.size()-1).setRevisionDate(resultSet.getTimestamp("revisionDate"));
				tradeList.get(tradeList.size()-1).setDealName(resultSet.getString("dealName"));
				tradeList.get(tradeList.size()-1).setDealType(resultSet.getString("dealType"));
				tradeList.get(tradeList.size()-1).setSourceListId(resultSet.getString("sourceListId"));
				tradeList.get(tradeList.size()-1).setSide(resultSet.getString("side"));
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
        
		return tradeList;
	}

	@Override
	public void updateTrade(Integer id, Trade trade) {
		logger.info("updateTrade(" + id + "," + trade + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "UPDATE trade "
		
			+ "SET "
						
				+ "account=" + "'" + trade.getAccount() + "',"
				+ "type=" + "'" + trade.getType() + "',"
				+ "buyQuantity=" + " " + trade.getBuyQuantity() + " "
			
    		+ "WHERE TradeId=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public void deleteTrade(Integer id) {
		logger.info("deleteTrade(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "DELETE FROM trade WHERE TradeId= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}
}