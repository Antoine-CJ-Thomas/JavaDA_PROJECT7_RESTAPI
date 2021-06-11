package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.CurvePointRestController;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CurvePointRestControllerTest {
	
	private CurvePointRestController curvePointRestController;
	
	@Mock
	private CurvePointServiceInterface curvePointServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private CurvePoint curvePoint;
	
    @Test
    public void createCurvePoint_OK() {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	curvePointRestController.createCurvePoint(curvePoint, bindingResult);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(1)).createCurvePoint(curvePoint);
    }
	
    @Test
    public void createCurvePoint_NOK() {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	curvePointRestController.createCurvePoint(curvePoint, bindingResult);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(0)).createCurvePoint(curvePoint);
    }
	
    @Test
    public void readCurvePoint() throws JsonProcessingException {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	curvePointRestController.readCurvePoint(1);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(1)).readCurvePoint(1);
    }
	
    @Test
    public void updateCurvePoint_OK() {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	
    	curvePointRestController.updateCurvePoint(1, curvePoint, bindingResult);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(1)).updateCurvePoint(1, curvePoint);
    }
	
    @Test
    public void updateCurvePoint_NOK() {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	curvePointRestController.updateCurvePoint(1, curvePoint, bindingResult);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(0)).updateCurvePoint(1, curvePoint);
    }
	
    @Test
    public void deleteCurvePoint() {
		
		//GIVEN
    	curvePointRestController = new CurvePointRestController(curvePointServiceInterface);

    	//WHEN
    	curvePointRestController.deleteCurvePoint(1);
		    	
    	//THEN
    	Mockito.verify(curvePointServiceInterface, Mockito.times(1)).deleteCurvePoint(1);
    }
}