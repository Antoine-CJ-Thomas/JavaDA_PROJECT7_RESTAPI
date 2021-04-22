package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repository.RuleRepository;
import com.nnk.springboot.repository.RuleRepositoryInterface;

@Service
public class RuleService implements RuleServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private RuleRepositoryInterface ruleRepositoryInterface;

	public RuleService() {
		logger.info("RuleService()");

		ruleRepositoryInterface = new RuleRepository();
	}

	@Override
	public void createRule(Rule rule) {
		logger.info("createRule(" + rule + ")");

		ruleRepositoryInterface.insertRule(rule);
	}

	@Override
	public Rule readRule(Integer id) {
		logger.info("readRule(" + id + ")");

		return ruleRepositoryInterface.selectRule(id);
	}

	@Override
	public ArrayList<Rule> readRuleList() {
		logger.info("readRuleList()");

		return ruleRepositoryInterface.selectRuleList();
	}

	@Override
	public void updateRule(Integer id, Rule rule) {
		logger.info("updateRule(" + id + "," + rule + ")");

		ruleRepositoryInterface.updateRule(id, rule);
	}

	@Override
	public void deleteRule(Integer id) {
		logger.info("deleteRule(" + id + ")");

		ruleRepositoryInterface.deleteRule(id);
	}
}