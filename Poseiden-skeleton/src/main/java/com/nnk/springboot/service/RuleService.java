package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repository.RuleRepository;
import com.nnk.springboot.repository.RuleRepositoryInterface;

/**
 * This class allows to interact with a rule repository
 */
@Service
public class RuleService implements RuleServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private RuleRepositoryInterface ruleRepositoryInterface;

	/**
	 * Creates a new RuleService
	 */
	public RuleService() {
		logger.info("RuleService()");

		ruleRepositoryInterface = new RuleRepository();
	}

	/**
	 * Creates a new RuleService with the specified RuleRepositoryInterface
	 * @param ruleRepositoryInterface : repository that this service will use
	 */
	public RuleService(RuleRepositoryInterface ruleRepositoryInterface) {
		logger.info("RuleService(" + ruleRepositoryInterface + ")");

		this.ruleRepositoryInterface = ruleRepositoryInterface;
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