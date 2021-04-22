package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rule;

public interface RuleRepositoryInterface {

	public void insertRule(Rule rule);
	
	public Rule selectRule(Integer id);
	
	public ArrayList<Rule> selectRuleList();
	
	public void updateRule(Integer id, Rule rule);
	
	public void deleteRule(Integer id);
}