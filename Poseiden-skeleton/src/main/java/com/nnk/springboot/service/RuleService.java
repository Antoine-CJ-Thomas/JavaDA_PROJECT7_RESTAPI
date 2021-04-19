package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repository.RuleRepository;
import com.nnk.springboot.repository.RuleRepositoryInterface;

@Service
public class RuleService implements RuleServiceInterface {

	@Autowired
	private RuleRepositoryInterface ruleRepositoryInterface;

	public RuleService() {
		
		ruleRepositoryInterface = new RuleRepository();
	}

	@Override
	public void createRule(Rule rule) {
		
		ruleRepositoryInterface.insertRule(rule);
	}


	@Override
	public Rule readRule(Integer id) {
		
		return ruleRepositoryInterface.selectRule(id);
	}


	@Override
	public ArrayList<Rule> readRuleList() {
		
		return ruleRepositoryInterface.selectRuleList();
	}


	@Override
	public void updateRule(Integer id, Rule rule) {
		
		ruleRepositoryInterface.updatetRule(id, rule);
	}


	@Override
	public void deleteRule(Integer id) {
		
		ruleRepositoryInterface.deleteRule(id);
	}
}