package com.nnk.springboot.unit.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repository.RuleRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RuleRepositoryTest {
	
	private RuleRepository ruleRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private Rule rule;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertRule() {
		
		//GIVEN
    	ruleRepository = new RuleRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ruleRepository.insertRule(rule);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectRule() {
		
		//GIVEN
    	ruleRepository = new RuleRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		ruleRepository.selectRule(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectRuleList() {
		
		//GIVEN
    	ruleRepository = new RuleRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ruleRepository.selectRuleList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateRule() {
		
		//GIVEN
    	ruleRepository = new RuleRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ruleRepository.updateRule(1, rule);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteRule() {
		
		//GIVEN
    	ruleRepository = new RuleRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ruleRepository.deleteRule(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
}