package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rule;

/**
 * This interface allows to implement rule service methods
*/
public interface RuleServiceInterface {

	public void createRule(Rule rule);

	public Rule readRule(Integer id);

	public ArrayList<Rule> readRuleList();

	public void updateRule(Integer id, Rule rule);

	public void deleteRule(Integer id);
}
