package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.RuleRestController;
import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.service.RuleServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RuleRestControllerTest {
	
	private RuleRestController ruleRestController;
	
	@Mock
	private RuleServiceInterface ruleServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Rule rule;
	
    @Test
    public void createRule_OK() {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	ruleRestController.createRule(rule, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(1)).createRule(rule);
    }
	
    @Test
    public void createRule_NOK() {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	ruleRestController.createRule(rule, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(0)).createRule(rule);
    }
	
    @Test
    public void readRule() throws JsonProcessingException {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	ruleRestController.readRule(1);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(1)).readRule(1);
    }
	
    @Test
    public void updateRule_OK() {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	ruleRestController.updateRule(1, rule, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(1)).updateRule(1, rule);
    }
	
    @Test
    public void updateRule_NOK() {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	ruleRestController.updateRule(1, rule, bindingResult);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(0)).updateRule(1, rule);
    }
	
    @Test
    public void deleteRule() {
		
		//GIVEN
    	ruleRestController = new RuleRestController(ruleServiceInterface);

    	//WHEN
    	ruleRestController.deleteRule(1);
		    	
    	//THEN
    	Mockito.verify(ruleServiceInterface, Mockito.times(1)).deleteRule(1);
    }
}