package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.LoginService;
import com.nnk.springboot.service.LoginServiceInterface;
import com.nnk.springboot.service.RuleService;
import com.nnk.springboot.service.RuleServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class allows to intercept rule requests
 */
@Controller
public class RuleController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private RuleServiceInterface ruleServiceInterface;
	private LoginServiceInterface loginServiceInterface;
	
	/**
	 * Creates a new RuleController
	 */
	public RuleController() {
		logger.info("RuleController()");

		ruleServiceInterface = new RuleService();
		loginServiceInterface = new LoginService();
	}

	/**
	 * Creates a new RuleController with the specified RuleServiceInterface and LoginServiceInterface
	 * @param ruleServiceInterface : rule service that this controller will use
	 * @param loginServiceInterface : login service that this controller will use
	 */
	public RuleController(RuleServiceInterface ruleServiceInterface, LoginServiceInterface loginServiceInterface) {
		logger.info("RuleController(" + ruleServiceInterface + "," + loginServiceInterface + ")");

		this.ruleServiceInterface = ruleServiceInterface;
		this.loginServiceInterface = loginServiceInterface;
	}

	/**
	 * Intercepts the request of the rule list table
	 * @param model : defines a holder for model attributes
     * @return The rule list template
	 */
	@RequestMapping("/ruleName/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("username", loginServiceInterface.getUsername());

		model.addAttribute("ruleList", ruleServiceInterface.readRuleList());

		return "/ruleName/list.html";
	}

	/**
	 * Intercepts the get request of the rule creation form
	 * @param rule : data of the Rule to create
     * @return The rule creation form template
	 */
	@GetMapping("/ruleName/add")
	public String addRuleForm(Rule rule) {
		logger.info("addRuleForm(" + rule + ")");

		return "/ruleName/add.html";
	}

	/**
	 * Intercepts the post request of the rule creation form
	 * @param rule : data of the Rule to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the rule list template or redirect to the rule creation form
	 */
	@PostMapping("/ruleName/validate")
	public String validate(@Valid Rule rule, BindingResult bindingResult, Model model) {
		logger.info("validate(" + rule + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			ruleServiceInterface.createRule(rule);

			return "redirect:/ruleName/list";
		}

		return "/ruleName/add.html";
	}

	/**
	 * Intercepts the get request of the rule update form
	 * @param id : id of the rule to update
	 * @param model : defines a holder for model attributes
     * @return Return the rule update form template
	 */
	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("rule", ruleServiceInterface.readRule(id));

		return "/ruleName/update.html";
	}

	/**
	 * Intercepts the post request of the rule update form
	 * @param id : id of the rule to update
	 * @param rule : data of the Rule to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the rule list template or redirect to the rule update form
	 */
	@PostMapping("/ruleName/update/{id}")
	public String updateRule(@PathVariable("id") Integer id, @Valid Rule rule, BindingResult bindingResult,
			Model model) {
		logger.info("updateRule(" + id + "," + rule + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			ruleServiceInterface.updateRule(id, rule);

			return "redirect:/ruleName/list";
		}

		return "/ruleName/update.html";
	}

	/**
	 * Intercepts the get request of the rule delete
	 * @param id : id of the rule to delete
	 * @param model : defines a holder for model attributes
     * @return Return the rule list template
	 */
	@GetMapping("/ruleName/delete/{id}")
	public String deleteRule(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteRule(" + id + "," + model + ")");

		ruleServiceInterface.deleteRule(id);

		return "redirect:/ruleName/list";
	}
}