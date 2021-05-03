package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.Rule;

/**
 * This class allows to prepare queries for the rule table and send them to the database configured
 */
@Component
public class RuleRepository implements RuleRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;

	/**
	 * Creates a new RuleRepository
	 */
	public RuleRepository() {
		logger.info("RuleRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	/**
	 * Creates a new RuleRepository with the specified DataBaseConfigurationInterface
	 * @param dataBaseConfigurationInterface : database configuration that this repository will use
	 */
	public RuleRepository(DataBaseConfigurationInterface dataBaseConfigurationInterface) {
		logger.info("RuleRepository(" + dataBaseConfigurationInterface + ")");

		this.dataBaseConfigurationInterface = dataBaseConfigurationInterface;
	}

	@Override
	public void insertRule(Rule rule) {
		logger.info("insertRule(" + rule + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "rulename ("
				
					+ "name,"
					+ "description,"
					+ "json,"
					+ "template,"
					+ "sqlStr,"
					+ "sqlPart) "
					
				+ "VALUES ("
			
					+ "'" + rule.getName() + "',"
					+ "'" + rule.getDescription() + "',"
					+ "'" + rule.getJson() + "',"
					+ "'" + rule.getTemplate() + "',"
					+ "'" + rule.getSqlStr() + "',"
					+ "'" + rule.getSqlPart() + "');";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public Rule selectRule(Integer id) {
		logger.info("selectRule(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM rulename WHERE Id=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		Rule rule = null;
		
    	try {

			if (resultSet.next()) {
				
				rule = new Rule();

				rule.setId(resultSet.getInt("Id"));
				rule.setName(resultSet.getString("name"));
				rule.setDescription(resultSet.getString("description"));
				rule.setJson(resultSet.getString("json"));
				rule.setTemplate(resultSet.getString("template"));
				rule.setSqlStr(resultSet.getString("sqlStr"));
				rule.setSqlPart(resultSet.getString("sqlPart"));
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
        
		return rule;
	}

	@Override
	public ArrayList<Rule> selectRuleList() {
		logger.info("selectRuleList()");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM rulename";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		ArrayList<Rule> ruleList = new ArrayList<Rule>();
		
    	try {

			while (resultSet.next()) {

				Rule rule = new Rule();

				rule.setId(resultSet.getInt("Id"));
				rule.setName(resultSet.getString("name"));
				rule.setDescription(resultSet.getString("description"));
				rule.setJson(resultSet.getString("json"));
				rule.setTemplate(resultSet.getString("template"));
				rule.setSqlStr(resultSet.getString("sqlStr"));
				rule.setSqlPart(resultSet.getString("sqlPart"));
				
				ruleList.add(rule);
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
        
		return ruleList;
	}

	@Override
	public void updateRule(Integer id, Rule rule) {
		logger.info("updateRule(" + id + "," + rule + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "UPDATE rulename "
			
				+ "SET "
				
					+ "name=" + "'" + rule.getName() + "',"
					+ "description=" + "'" + rule.getDescription() + "',"
					+ "json=" + "'" + rule.getJson() + "',"
					+ "template=" + "'" + rule.getTemplate() + "',"
					+ "sqlStr=" + "'" + rule.getSqlStr() + "',"
					+ "sqlPart=" + "'" + rule.getSqlPart() + "' "
		
    			+ "WHERE Id=" + id + ";";
		
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}

	@Override
	public void deleteRule(Integer id) {
		logger.info("deleteRule(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM rulename WHERE Id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
	}
}