package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rule;

/**
 * This interface allows to implement rule repository methods
*/
public interface RuleRepositoryInterface {

	public void insertRule(Rule rule);
	
	public Rule selectRule(Integer id);
	
	public ArrayList<Rule> selectRuleList();
	
	public void updateRule(Integer id, Rule rule);
	
	public void deleteRule(Integer id);
}