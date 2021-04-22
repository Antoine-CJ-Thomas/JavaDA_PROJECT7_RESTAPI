package com.nnk.springboot.repository;

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
import com.nnk.springboot.domain.CurvePoint;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CurvePointRepositoryTest {
	
	private CurvePointRepository curvePointRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private CurvePoint curvePoint;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertCurvePoint() {
		
		//GIVEN
    	curvePointRepository = new CurvePointRepository(dataBaseConfigurationInterface);

    	//WHEN
    	curvePointRepository.insertCurvePoint(curvePoint);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectCurvePoint() {
		
		//GIVEN
    	curvePointRepository = new CurvePointRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		curvePointRepository.selectCurvePoint(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectCurvePointList() {
		
		//GIVEN
    	curvePointRepository = new CurvePointRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		curvePointRepository.selectCurvePointList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateCurvePoint() {
		
		//GIVEN
    	curvePointRepository = new CurvePointRepository(dataBaseConfigurationInterface);

    	//WHEN
    	curvePointRepository.updateCurvePoint(1, curvePoint);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteCurvePoint() {
		
		//GIVEN
    	curvePointRepository = new CurvePointRepository(dataBaseConfigurationInterface);

    	//WHEN
    	curvePointRepository.deleteCurvePoint(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }

}
