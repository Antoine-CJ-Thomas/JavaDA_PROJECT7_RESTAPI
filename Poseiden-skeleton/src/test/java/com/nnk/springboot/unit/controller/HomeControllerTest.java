package com.nnk.springboot.unit.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.nnk.springboot.controller.HomeController;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	
	private HomeController homeController;
	
	@Mock
	private Model model;
	
    @Test
    public void home() {
		
		//GIVEN
    	homeController = new HomeController();

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(homeController.home(model).equals("/home.html"));
    }
	
    @Test
    public void addBidForm() {
		
		//GIVEN
    	homeController = new HomeController();

    	//WHEN
		    	
    	//THEN
    	Assert.assertTrue(homeController.adminHome(model).equals("redirect:/bidList/list"));
    }
}