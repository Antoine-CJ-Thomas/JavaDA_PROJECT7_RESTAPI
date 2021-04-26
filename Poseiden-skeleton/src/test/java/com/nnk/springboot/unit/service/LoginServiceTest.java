package com.nnk.springboot.unit.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repository.UserRepositoryInterface;
import com.nnk.springboot.service.LoginService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	private LoginService loginService;
	
	@Mock
	private UserRepositoryInterface userRepositoryInterface;
	
	@Mock
	private User user;
	
    @Test
    public void loadUserByUsername() {
		
		//GIVEN
    	loginService = new LoginService(userRepositoryInterface);

    	//WHEN
		when(userRepositoryInterface.selectUser("username")).thenReturn(user);
		
    	loginService.loadUserByUsername("username");
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(2)).selectUser("username");
    }
}
