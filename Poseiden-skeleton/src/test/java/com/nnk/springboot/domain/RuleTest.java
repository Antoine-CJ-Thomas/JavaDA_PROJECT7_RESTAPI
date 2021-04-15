package com.nnk.springboot.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleTest {
	
	private Rule rule;
	
    @Test
    public void setAndGetId() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setId(1);
    	
    	//THEN
    	Assert.assertTrue(rule.getId() == 1);
    }
	
    @Test
    public void setAndGetName() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setName("Name");
    	
    	//THEN
    	Assert.assertTrue(rule.getName().equals("Name"));
    }
	
    @Test
    public void setAndGetDescription() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setDescription("Description");
    	
    	//THEN
    	Assert.assertTrue(rule.getDescription().equals("Description"));
    }
	
    @Test
    public void setAndGetJson() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setJson("Json");
    	
    	//THEN
    	Assert.assertTrue(rule.getJson().equals("Json"));
    }
	
    @Test
    public void setAndGetTemplate() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setTemplate("Template");
    	
    	//THEN
    	Assert.assertTrue(rule.getTemplate().equals("Template"));
    }
	
    @Test
    public void setAndGetSqlStr() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setSqlStr("SqlStr");
    	
    	//THEN
    	Assert.assertTrue(rule.getSqlStr().equals("SqlStr"));
    }
	
    @Test
    public void setAndGetSqlPart() {
		
		//GIVEN
    	rule = new Rule();

    	//WHEN
    	rule.setSqlPart("SqlPart");
    	
    	//THEN
    	Assert.assertTrue(rule.getSqlPart().equals("SqlPart"));
    }
}
