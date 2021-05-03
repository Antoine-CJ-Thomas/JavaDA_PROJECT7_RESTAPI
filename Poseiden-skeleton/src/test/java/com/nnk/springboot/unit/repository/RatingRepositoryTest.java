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
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repository.RatingRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RatingRepositoryTest {
	
	private RatingRepository ratingRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private Rating rating;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertRating() {
		
		//GIVEN
    	ratingRepository = new RatingRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ratingRepository.insertRating(rating);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectRating() {
		
		//GIVEN
    	ratingRepository = new RatingRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		ratingRepository.selectRating(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectRatingList() {
		
		//GIVEN
    	ratingRepository = new RatingRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ratingRepository.selectRatingList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateRating() {
		
		//GIVEN
    	ratingRepository = new RatingRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ratingRepository.updateRating(1, rating);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteRating() {
		
		//GIVEN
    	ratingRepository = new RatingRepository(dataBaseConfigurationInterface);

    	//WHEN
    	ratingRepository.deleteRating(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
}
