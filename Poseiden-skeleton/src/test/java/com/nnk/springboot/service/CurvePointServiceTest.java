package com.nnk.springboot.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repository.CurvePointRepositoryInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CurvePointServiceTest {
	
	private CurvePointService curvePointService;
	
	@Mock
	private CurvePointRepositoryInterface curvePointRepositoryInterface;
	
	@Mock
	private CurvePoint curvePoint;
	
    @Test
    public void createCurvePoint() {
		
		//GIVEN
    	curvePointService = new CurvePointService(curvePointRepositoryInterface);

    	//WHEN
    	curvePointService.createCurvePoint(curvePoint);
    	
    	//THEN
        verify(curvePointRepositoryInterface, Mockito.times(1)).insertCurvePoint(curvePoint);
    }
	
    @Test
    public void readCurvePoint() {
		
		//GIVEN
    	curvePointService = new CurvePointService(curvePointRepositoryInterface);

    	//WHEN
    	curvePointService.readCurvePoint(1);
    	
    	//THEN
        verify(curvePointRepositoryInterface, Mockito.times(1)).selectCurvePoint(1);
    }
	
    @Test
    public void readCurvePointList() {
		
		//GIVEN
    	curvePointService = new CurvePointService(curvePointRepositoryInterface);

    	//WHEN
    	curvePointService.readCurvePointList();
    	
    	//THEN
        verify(curvePointRepositoryInterface, Mockito.times(1)).selectCurvePointList();
    }
	
    @Test
    public void updateCurvePoint() {
		
		//GIVEN
    	curvePointService = new CurvePointService(curvePointRepositoryInterface);

    	//WHEN
    	curvePointService.updateCurvePoint(1, curvePoint);
    	
    	//THEN
        verify(curvePointRepositoryInterface, Mockito.times(1)).updateCurvePoint(1, curvePoint);
    }
	
    @Test
    public void deleteCurvePoint() {
		
		//GIVEN
    	curvePointService = new CurvePointService(curvePointRepositoryInterface);

    	//WHEN
    	curvePointService.deleteCurvePoint(1);
    	
    	//THEN
        verify(curvePointRepositoryInterface, Mockito.times(1)).deleteCurvePoint(1);
    }
}
