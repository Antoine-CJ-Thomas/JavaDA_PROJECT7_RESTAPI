package com.nnk.springboot.unit.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repository.RuleRepositoryInterface;
import com.nnk.springboot.service.RuleService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RulseServiceTest {
	
	private RuleService ruleService;
	
	@Mock
	private RuleRepositoryInterface ruleRepositoryInterface;
	
	@Mock
	private Rule rule;
	
    @Test
    public void createRule() {
		
		//GIVEN
    	ruleService = new RuleService(ruleRepositoryInterface);

    	//WHEN
    	ruleService.createRule(rule);
    	
    	//THEN
        verify(ruleRepositoryInterface, Mockito.times(1)).insertRule(rule);
    }
	
    @Test
    public void readRule() {
		
		//GIVEN
    	ruleService = new RuleService(ruleRepositoryInterface);

    	//WHEN
    	ruleService.readRule(1);
    	
    	//THEN
        verify(ruleRepositoryInterface, Mockito.times(1)).selectRule(1);
    }
	
    @Test
    public void readRuleList() {
		
		//GIVEN
    	ruleService = new RuleService(ruleRepositoryInterface);

    	//WHEN
    	ruleService.readRuleList();
    	
    	//THEN
        verify(ruleRepositoryInterface, Mockito.times(1)).selectRuleList();
    }
	
    @Test
    public void updateRule() {
		
		//GIVEN
    	ruleService = new RuleService(ruleRepositoryInterface);

    	//WHEN
    	ruleService.updateRule(1, rule);
    	
    	//THEN
        verify(ruleRepositoryInterface, Mockito.times(1)).updateRule(1, rule);
    }
	
    @Test
    public void deleteRule() {
		
		//GIVEN
    	ruleService = new RuleService(ruleRepositoryInterface);

    	//WHEN
    	ruleService.deleteRule(1);
    	
    	//THEN
        verify(ruleRepositoryInterface, Mockito.times(1)).deleteRule(1);
    }
}
