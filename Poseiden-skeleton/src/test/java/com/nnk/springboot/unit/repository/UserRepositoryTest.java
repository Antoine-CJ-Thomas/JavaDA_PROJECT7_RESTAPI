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
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {
	
	private UserRepository userRepository;
	
	@Mock
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	@Mock
	private User user;
	
	@Mock
	private ResultSet resultSet;
	
    @Test
    public void insertUser() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
    	userRepository.insertUser(user);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void selectUserByUsername() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		userRepository.selectUser("username");
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectUserById() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   
		userRepository.selectUser(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void selectUserList() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
		when(dataBaseConfigurationInterface.executeQuery(any())).thenReturn(resultSet);
		
		try {
			
			when(resultSet.next()).thenReturn(false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		userRepository.selectUserList();
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeQuery(any());
    }
	
    @Test
    public void updateUser() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
    	userRepository.updateUser(1, user);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
	
    @Test
    public void deleteUser() {
		
		//GIVEN
    	userRepository = new UserRepository(dataBaseConfigurationInterface);

    	//WHEN
    	userRepository.deleteUser(1);
    	
    	//THEN
        verify(dataBaseConfigurationInterface, Mockito.times(1)).executeUpdate(any());
    }
}