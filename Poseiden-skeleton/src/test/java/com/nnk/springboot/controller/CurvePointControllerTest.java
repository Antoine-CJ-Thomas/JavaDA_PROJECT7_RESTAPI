package com.nnk.springboot.controller;

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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CurvePointControllerTest {
	
	private CurvePointController curvePointController;
	
	@Mock
	private CurvePointServiceInterface curvePointServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private CurvePoint curvePoint;

	@Mock
	private ArrayList<CurvePoint> curvePointList;
	
    @Test
    public void home() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(curvePointServiceInterface.readCurvePointList()).thenReturn(curvePointList);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.home(model).equals("/curvePoint/list.html"));
    }
	
    @Test
    public void addCurvePointForm() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.addCurvePointForm(curvePoint).equals("/curvePoint/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.validate(curvePoint, bindingResult, model).equals("redirect:/curvePoint/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.validate(curvePoint, bindingResult, model).equals("/curvePoint/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(curvePointServiceInterface.readCurvePoint(1)).thenReturn(curvePoint);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.showUpdateForm(1, model).equals("/curvePoint/update.html"));
    }
	
    @Test
    public void updateCurvePoint_OK() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.updateCurvePoint(1, curvePoint, bindingResult, model).equals("redirect:/curvePoint/list"));
    }
	
    @Test
    public void updateCurvePoint_NOK() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.updateCurvePoint(1, curvePoint, bindingResult, model).equals("/curvePoint/update.html"));
    }
	
    @Test
    public void deleteCurvePoint() {
		
		//GIVEN
    	curvePointController = new CurvePointController(curvePointServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(curvePointController.deleteCurvePoint(1, model).equals("redirect:/curvePoint/list"));
    }
}