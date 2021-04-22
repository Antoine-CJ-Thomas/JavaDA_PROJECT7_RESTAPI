package com.nnk.springboot.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepositoryInterface;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	private UserService userService;
	
	@Mock
	private UserRepositoryInterface userRepositoryInterface;
	
	@Mock
	private User user;
	
    @Test
    public void createUser() {
		
		//GIVEN
    	userService = new UserService(userRepositoryInterface);

    	//WHEN
    	userService.createUser(user);
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).insertUser(user);
    }
	
    @Test
    public void readUser() {
		
		//GIVEN
    	userService = new UserService(userRepositoryInterface);

    	//WHEN
    	userService.readUser(1);
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).selectUser(1);
    }
	
    @Test
    public void readUserList() {
		
		//GIVEN
    	userService = new UserService(userRepositoryInterface);

    	//WHEN
    	userService.readUserList();
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).selectUserList();
    }
	
    @Test
    public void updateUser() {
		
		//GIVEN
    	userService = new UserService(userRepositoryInterface);

    	//WHEN
    	userService.updateUser(1, user);
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).updateUser(1, user);
    }
	
    @Test
    public void deleteUser() {
		
		//GIVEN
    	userService = new UserService(userRepositoryInterface);

    	//WHEN
    	userService.deleteUser(1);
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).deleteUser(1);
    }
}
