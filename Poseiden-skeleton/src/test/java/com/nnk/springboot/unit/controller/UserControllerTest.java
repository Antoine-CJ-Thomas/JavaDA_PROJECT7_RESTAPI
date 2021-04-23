package com.nnk.springboot.unit.controller;

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

import com.nnk.springboot.controller.UserController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserServiceInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	private UserController userController;
	
	@Mock
	private UserServiceInterface userServiceInterface;
	
	@Mock
	private BindingResult bindingResult;
	
	@Mock
	private Model model;
	
	@Mock
	private User user;

	@Mock
	private ArrayList<User> userList;
	
    @Test
    public void home() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(userServiceInterface.readUserList()).thenReturn(userList);
		    	
    	//THEN
    	Assert.assertTrue(userController.home(model).equals("/user/list.html"));
    }
	
    @Test
    public void addUserForm() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(userController.addUserForm(user).equals("/user/add.html"));
    }
	
    @Test
    public void validate_OK() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		when(user.getPassword()).thenReturn("password");
		    	
    	//THEN
    	Assert.assertTrue(userController.validate(user, bindingResult, model).equals("redirect:/user/list"));
    }
	
    @Test
    public void validate_NOK() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(userController.validate(user, bindingResult, model).equals("/user/add.html"));
    }
	
    @Test
    public void showUpdateForm() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(userServiceInterface.readUser(1)).thenReturn(user);
		    	
    	//THEN
    	Assert.assertTrue(userController.showUpdateForm(1, model).equals("/user/update.html"));
    }
	
    @Test
    public void updateUser_OK() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(false);
		when(user.getPassword()).thenReturn("password");
		    	
    	//THEN
    	Assert.assertTrue(userController.updateUser(1, user, bindingResult, model).equals("redirect:/user/list"));
    }
	
    @Test
    public void updateUser_NOK() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		when(bindingResult.hasErrors()).thenReturn(true);
		    	
    	//THEN
    	Assert.assertTrue(userController.updateUser(1, user, bindingResult, model).equals("/user/update.html"));
    }
	
    @Test
    public void deleteUser() {
		
		//GIVEN
    	userController = new UserController(userServiceInterface);

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(userController.deleteUser(1, model).equals("redirect:/user/list"));
    }
}