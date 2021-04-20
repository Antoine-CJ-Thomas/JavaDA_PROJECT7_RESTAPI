package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.RuleService;
import com.nnk.springboot.service.RuleServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RuleController {
	// TODO: Inject RuleName service

	private static final Logger logger = LogManager.getLogger("RuleController");

	@Autowired
	private RuleServiceInterface ruleServiceInterface;

	public RuleController() {
		logger.info("RuleController");

		ruleServiceInterface = new RuleService();
	}

	@RequestMapping("/rule/list")
	public String home(Model model) {
		logger.info("home");
		// TODO: find all RuleName, add to model

		model.addAttribute("ruleList", ruleServiceInterface.readRuleList());

		return "rule/list";
	}

	@GetMapping("/rule/add")
	public String addRuleForm(Rule rule) {
		logger.info("addRuleForm");

		return "rule/add";
	}

	@PostMapping("/rule/validate")
	public String validate(@Valid Rule rule, BindingResult result, Model model) {
		logger.info("validate");
		// TODO: check data valid and save to db, after saving return RuleName list

		ruleServiceInterface.createRule(rule);

		return "rule/add";
	}

	@GetMapping("/rule/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm");
		// TODO: get RuleName by Id and to model then show to the form

		model.addAttribute("rule", ruleServiceInterface.readRule(id));

		return "rule/update";
	}

	@PostMapping("/rule/update/{id}")
	public String updateRule(@PathVariable("id") Integer id, @Valid Rule rule, BindingResult result, Model model) {
		logger.info("updateRule");
		// TODO: check required fields, if valid call service to update RuleName and
		// return RuleName list

		ruleServiceInterface.updateRule(id, rule);

		return "redirect:/rule/list";
	}

	@GetMapping("/rule/delete/{id}")
	public String deleteRule(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteRule");
		// TODO: Find RuleName by Id and delete the RuleName, return to Rule list

		ruleServiceInterface.deleteRule(id);

		return "redirect:/rule/list";
	}
}
