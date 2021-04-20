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
import com.nnk.springboot.domain.Trade;

@Component
public class TradeRepository implements TradeRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("TradeRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public TradeRepository() {
		logger.info("TradeRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertTrade(Trade trade) {
		logger.info("insertTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "trade ("
							
					+ "account,"
					+ "type,"
					+ "buyQuantity,"
					+ "sellQuantity,"
					+ "buyPrice,"
					
					+ "sellPrice,"
					+ "tradeDate,"
					+ "security,"
					+ "status,"
					+ "trader,"
					
					+ "benchmark,"
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
			
					+ "'" + trade.getAccount() + "',"
					+ "'" + trade.getType() + "',"
					+ " " + trade.getBuyQuantity() + ","
					+ " " + trade.getSellQuantity() + ","
					+ " " + trade.getBuyPrice() + ","
					
					+ " " + trade.getSellPrice() + ","
					+ "'" + trade.getTradeDate() + "',"
					+ "'" + trade.getSecurity() + "',"
					+ "'" + trade.getStatus() + "',"
					+ "'" + trade.getTrader() + "',"
					
					+ "'" + trade.getBenchmark() + "',"
					+ "'" + trade.getBook() + "',"
					+ "'" + trade.getCreationName() + "',"
					+ "'" + trade.getCreationDate() + "',"
					+ "'" + trade.getRevisionName() + "',"
					
					+ "'" + trade.getRevisionDate() + "',"
					+ "'" + trade.getDealName() + "',"
					+ "'" + trade.getDealType() + "',"
					+ "'" + trade.getSourceListId() + "',"
					+ "'" + trade.getSide() + "');";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public Trade selectTrade(Integer id) {
		logger.info("selectTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
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
		logger.info("selectTradeList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Trade> tradeList = new ArrayList<Trade>();
		
    	try {

			if (resultSet.next()) {
				
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
	public void updatetTrade(Integer id, Trade trade) {
		logger.info("updatetTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
		= "UPDATE trade "
		
			+ "SET "
						
				+ "account=" + "'" + trade.getAccount() + "',"
				+ "type=" + "'" + trade.getType() + "',"
				+ "buyQuantity=" + " " + trade.getBuyQuantity() + ","
				+ "sellQuantity=" + " " + trade.getSellQuantity() + ","
				+ "buyPrice=" + " " + trade.getBuyPrice() + ","
				
				+ "sellPrice=" + "'" + trade.getSellPrice() + "',"
				+ "tradeDate=" + "'" + trade.getTradeDate() + "',"
				+ "security=" + "'" + trade.getSecurity() + "',"
				+ "status=" + "'" + trade.getStatus() + "',"
				+ "trader=" + "'" + trade.getTrader() + "',"
				
				+ "benchmark=" + " " + trade.getBenchmark() + ","
				+ "book=" + "'" + trade.getBook() + "',"
				+ "creationName=" + "'" + trade.getCreationName() + "',"
				+ "creationDate=" + "'" + trade.getCreationDate() + "',"
				+ "revisionName=" + "'" + trade.getRevisionName() + "',"
				
				+ "revisionDate=" + "'" + trade.getRevisionDate() + "',"
				+ "dealName=" + "'" + trade.getDealName() + "',"
				+ "dealType=" + "'" + trade.getDealType() + "',"
				+ "sourceListId=" + "'" + trade.getSourceListId() + "',"
				+ "side=" + "'" + trade.getSide() + "'"
			
    		+ "WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public void deleteTrade(Integer id) {
		logger.info("deleteTrade");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "DELETE FROM trade WHERE TradeId= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}
}