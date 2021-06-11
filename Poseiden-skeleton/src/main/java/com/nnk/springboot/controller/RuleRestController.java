package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.RuleService;
import com.nnk.springboot.service.RuleServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class allows to intercept rule REST requests
 */
@RestController
public class RuleRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private RuleServiceInterface ruleServiceInterface;
	
	/**
	 * Creates a new RuleRestController
	 */
	public RuleRestController() {
		logger.info("ruleController()");

		ruleServiceInterface = new RuleService();
	}

	/**
	 * Creates a new RuleRestController with the specified RuleServiceInterface
	 * @param ruleServiceInterface : service that this controller will use
	 */
	public RuleRestController(RuleServiceInterface ruleServiceInterface) {
		logger.info("ruleController(" + ruleServiceInterface + ")");

		this.ruleServiceInterface = ruleServiceInterface;
	}

	/**
	 * Intercepts the creating request of a rule
	 * @param rule : data of the rule to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/rule/create")
	public void createRule(@Valid Rule rule, BindingResult bindingResult) {
		logger.info("createRule(" + rule + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			ruleServiceInterface.createRule(rule);
		}
	}

	/**
	 * Intercepts the getting request of a rule
	 * @param id : id of the rule to read
     * @return Return the rule (JSon)
	 */
	@GetMapping("/rule/read")
	public String readRule(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readRule(" + id + ")");

        return objectMapper.writeValueAsString(ruleServiceInterface.readRule(id));
	}

	/**
	 * Intercepts the updating request of a rule
	 * @param id : id of the rule to update
	 * @param rule : data of the rule to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/rule/update")
	public void updateRule(@RequestParam("id") Integer id, @Valid Rule rule, BindingResult bindingResult) {
		logger.info("updateRule(" + id + "," + rule + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			ruleServiceInterface.updateRule(id, rule);
		}
	}

	/**
	 * Intercepts the deleting request of a rule
	 * @param id : id of the rule to delete
	 */
	@DeleteMapping("/rule/delete")
	public void deleteRule(@RequestParam("id") Integer id) {
		logger.info("deleteRule(" + id + ")");
		
		ruleServiceInterface.deleteRule(id);
	}
}