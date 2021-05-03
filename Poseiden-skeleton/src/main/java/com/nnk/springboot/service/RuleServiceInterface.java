package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rule;

/**
 * This interface allows to implement rule service methods
*/
public interface RuleServiceInterface {
	
	/**
	 * Create a Rule
	 * @param rule : data of the Rule to create
	 */
	public void createRule(Rule rule);
	
	/**
	 * Read a Rule
	 * @param id : id of the Rule to read
     * @return The Rule that was read
	 */
	public Rule readRule(Integer id);
	
	/**
	 * Read the Rule list
     * @return The Rule list that was read
	 */
	public ArrayList<Rule> readRuleList();
	
	/**
	 * Update a Rule
	 * @param id : id of the Rule to update
	 * @param rule : data of the Rule to update
	 */
	public void updateRule(Integer id, Rule rule);
	
	/**
	 * Delete a Rule
	 * @param id : id of the Rule to delete
	 */
	public void deleteRule(Integer id);
}
