package com.nnk.springboot.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class HomeControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	@Test
	@Order(1)
	@WithMockUser
	void home() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();

		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	@Order(2)
	@WithMockUser
	void adminHome() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
