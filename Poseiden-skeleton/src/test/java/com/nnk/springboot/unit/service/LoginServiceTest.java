package com.nnk.springboot.unit.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.repository.UserRepositoryInterface;
import com.nnk.springboot.service.LoginService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	private LoginService loginService;
	
	@Mock
	private UserRepositoryInterface userRepositoryInterface;
	
    @Test
    public void loadUserByUsername() {
		
		//GIVEN
    	loginService = new LoginService(userRepositoryInterface);

    	//WHEN
    	loginService.loadUserByUsername("username");
    	
    	//THEN
        verify(userRepositoryInterface, Mockito.times(1)).selectUser("username");
    }
}
