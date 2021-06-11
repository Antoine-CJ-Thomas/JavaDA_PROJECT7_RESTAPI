package com.nnk.springboot.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nnk.springboot.controller.UserRestController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {
	
	private UserRestController userRestController;
	
	@Mock
	private UserServiceInterface userServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private User user;
	
    @Test
    public void createUser_OK() {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	Mockito.when(user.getPassword()).thenReturn("password");
    	
    	userRestController.createUser(user, bindingResult);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(1)).createUser(user);
    }
	
    @Test
    public void createUser_NOK() {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	userRestController.createUser(user, bindingResult);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(0)).createUser(user);
    }
	
    @Test
    public void readUser() throws JsonProcessingException {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	userRestController.readUser(1);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(1)).readUser(1);
    }
	
    @Test
    public void updateUser_OK() {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(false);
    	Mockito.when(user.getPassword()).thenReturn("password");
    	
    	userRestController.updateUser(1, user, bindingResult);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(1)).updateUser(1, user);
    }
	
    @Test
    public void updateUser_NOK() {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	Mockito.when(bindingResult.hasErrors()).thenReturn(true);
    	
    	userRestController.updateUser(1, user, bindingResult);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(0)).updateUser(1, user);
    }
	
    @Test
    public void deleteUser() {
		
		//GIVEN
    	userRestController = new UserRestController(userServiceInterface);

    	//WHEN
    	userRestController.deleteUser(1);
		    	
    	//THEN
    	Mockito.verify(userServiceInterface, Mockito.times(1)).deleteUser(1);
    }
}