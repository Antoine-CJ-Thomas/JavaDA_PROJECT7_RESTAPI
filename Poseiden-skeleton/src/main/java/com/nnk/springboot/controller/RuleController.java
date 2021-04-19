package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.RuleService;
import com.nnk.springboot.service.RuleServiceInterface;

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
	
	@Autowired
	private RuleServiceInterface ruleServiceInterface;
	
	public RuleController() {
		
		ruleServiceInterface = new RuleService();
	}

    @RequestMapping("/ruleName/list")
    public String home(Model model) {
        // TODO: find all RuleName, add to model
    	
    	model.addAttribute("ruleList", ruleServiceInterface.readRuleList());
    	
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(Rule rule) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid Rule rule, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
    	
    	ruleServiceInterface.createRule(rule);
    	
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form

    	model.addAttribute("rule", ruleServiceInterface.readRule(id));
    	
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRule(@PathVariable("id") Integer id, @Valid Rule rule, BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
    	
    	ruleServiceInterface.updateRule(id, rule);
    	
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRule(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
    	
    	ruleServiceInterface.deleteRule(id);
    	
        return "redirect:/ruleName/list";
    }
}
