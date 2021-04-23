package com.nnk.springboot.unit.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.nnk.springboot.controller.RuleController;
import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.RuleServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RuleControllerTest {
	
	private RuleController RuleController;
	
	@Mock
	private RuleServiceInterface RuleServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private Rule Rule;

	@Mock
	private ArrayList<Rule> RuleList;
	
    @Test
    public void home() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(RuleServiceInterface.readRuleList()).thenReturn(RuleList);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.home(model).equals("/ruleName/list.html"));
    }
	
    @Test
    public void addRuleForm() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(RuleController.addRuleForm(Rule).equals("/ruleName/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.validate(Rule, bindingResult, model).equals("redirect:/ruleName/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.validate(Rule, bindingResult, model).equals("/ruleName/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(RuleServiceInterface.readRule(1)).thenReturn(Rule);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.showUpdateForm(1, model).equals("/ruleName/update.html"));
    }
	
    @Test
    public void updateRule_OK() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.updateRule(1, Rule, bindingResult, model).equals("redirect:/ruleName/list"));
    }
	
    @Test
    public void updateRule_NOK() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(RuleController.updateRule(1, Rule, bindingResult, model).equals("/ruleName/update.html"));
    }
	
    @Test
    public void deleteRule() {
		
		//GIVEN
    	RuleController = new RuleController(RuleServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(RuleController.deleteRule(1, model).equals("redirect:/ruleName/list"));
    }
}