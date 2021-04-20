package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Rule;

@Component
public class RuleRepository implements RuleRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("RuleRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public RuleRepository() {
		logger.info("RuleRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertRule(Rule rule) {
		logger.info("insertRule");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Rule selectRule(Integer id) {
		logger.info("selectRule");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Rule> selectRuleList() {
		logger.info("selectRuleList");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetRule(Integer id, Rule rule) {
		logger.info("updatetRule");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteRule(Integer id) {
		logger.info("deleteRule");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = null;
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}