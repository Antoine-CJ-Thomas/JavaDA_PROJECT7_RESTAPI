package com.nnk.springboot.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
	
	private User user;
	
    @Test
    public void setAndGetId() {
		
		//GIVEN
    	user = new User();

    	//WHEN
    	user.setId(1);
    	
    	//THEN
    	Assert.assertTrue(user.getId() == 1);
    }
	
    @Test
    public void setAndGetUsername() {
		
		//GIVEN
    	user = new User();

    	//WHEN
    	user.setUsername("Username");
    	
    	//THEN
    	Assert.assertTrue(user.getUsername().equals("Username"));
    }
	
    @Test
    public void setAndGetPassword() {
		
		//GIVEN
    	user = new User();

    	//WHEN
    	user.setPassword("Password");
    	
    	//THEN
    	Assert.assertTrue(user.getPassword().equals("Password"));
    }
	
    @Test
    public void setAndGetFullname() {
		
		//GIVEN
    	user = new User();

    	//WHEN
    	user.setFullname("Fullname");
    	
    	//THEN
    	Assert.assertTrue(user.getFullname().equals("Fullname"));
    }
	
    @Test
    public void setAndGetRole() {
		
		//GIVEN
    	user = new User();

    	//WHEN
    	user.setRole("Role");
    	
    	//THEN
    	Assert.assertTrue(user.getRole().equals("Role"));
    }
}
