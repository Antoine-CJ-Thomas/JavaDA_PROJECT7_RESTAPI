package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Rule;

/**
 * This interface allows to implement rule repository methods
*/
public interface RuleRepositoryInterface {

	/**
	 * Insert a Rule in the Rule table
	 * @param rule : data of the Rule to insert
	 */
	public void insertRule(Rule rule);
	
	/**
	 * Select a Rule in the Rule table
	 * @param id : id of the Rule to select
     * @return The Rule that was selected
	 */
	public Rule selectRule(Integer id);

	/**
	 * Select the Rule list of the Rule table
     * @return The Rule list that was selected
	 */
	public ArrayList<Rule> selectRuleList();
	
	/**
	 * Update a Rule in the Rule table
	 * @param id : id of the Rule to update
	 * @param rule : data of the Rule to update
	 */
	public void updateRule(Integer id, Rule rule);

	/**
	 * Delete a Rule in the Rule table
	 * @param id : id of the Rule to delete
	 */
	public void deleteRule(Integer id);
}