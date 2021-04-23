package com.nnk.springboot.domain;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurvePointTest {
	
	private CurvePoint curvePoint;
	
    @Test
    public void setAndGetId() {
		
		//GIVEN
    	curvePoint = new CurvePoint();

    	//WHEN
    	curvePoint.setId(1);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getId() == 1);
    }
	
    @Test
    public void setAndGetCurveId() {
		
		//GIVEN
    	curvePoint = new CurvePoint();

    	//WHEN
    	curvePoint.setCurveId(1);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getCurveId() == 1);
    }
	
    @Test
    public void setAndGetAsOfDate() {
		
		//GIVEN
    	curvePoint = new CurvePoint();
    	Timestamp asOfDate = new Timestamp(0);

    	//WHEN
    	curvePoint.setAsOfDate(asOfDate);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getAsOfDate() == asOfDate);
    }
	
    @Test
    public void setAndGetTerm() {
		
		//GIVEN
    	curvePoint = new CurvePoint();

    	//WHEN
    	curvePoint.setTerm(10.0);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getTerm() == 10.0);
    }
	
    @Test
    public void setAndGetValue() {
		
		//GIVEN
    	curvePoint = new CurvePoint();

    	//WHEN
    	curvePoint.setValue(10.0);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getValue() == 10.0);
    }
	
    @Test
    public void setAndGetCreationDate() {
		
		//GIVEN
    	curvePoint = new CurvePoint();
    	Timestamp creationDate = new Timestamp(0);

    	//WHEN
    	curvePoint.setCreationDate(creationDate);
    	
    	//THEN
    	Assert.assertTrue(curvePoint.getCreationDate() == creationDate);
    }
}
