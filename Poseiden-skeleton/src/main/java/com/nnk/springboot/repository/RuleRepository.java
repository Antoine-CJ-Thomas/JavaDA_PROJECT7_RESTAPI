package com.nnk.springboot.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationeMySql;
import com.nnk.springboot.domain.Rule;

@Component
public class RuleRepository implements RuleRepositoryInterface {

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public RuleRepository() {
		
		dataBaseConfigurationInterface = new DataBaseConfigurationeMySql();
	}

	@Override
	public void insertRule(Rule rule) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public Rule selectRule(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public ArrayList<Rule> selectRuleList() {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeQuery(queryList);
        
		return null;
	}

	@Override
	public void updatetRule(Integer id, Rule rule) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public void deleteRule(Integer id) {
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}