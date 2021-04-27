package com.nnk.springboot.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

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

import com.nnk.springboot.domain.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	static private User createdTestUser;
	static private ArrayList<User> userList;
	
	@Test
	@Order(1)
	@WithMockUser
	void addUserForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/add")).andReturn();

		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(2)
	@WithMockUser
	void validate() throws Exception {

		// GIVEN		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN	
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/validate")
				.param("username", "aaaaaaaa")
				.param("password", "bbbbbbbb")
				.param("fullname", "cccccccc")
				.param("role", "dddddddd")).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(3)
	@WithMockUser
	@SuppressWarnings("unchecked")
	void home() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/list")).andReturn();
		
		userList = ((ArrayList<User>) mvcResult.getModelAndView().getModel().get("userList"));
		createdTestUser = userList.get(userList.size()-1);
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(4)
	@WithMockUser
	void showUpdateForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/update/" + createdTestUser.getId())).andReturn();
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(5)
	@WithMockUser
	void updateUser() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/update/" + createdTestUser.getId())
				.param("username", "eeeeeeee")
				.param("password", "ffffffff")
				.param("fullname", "gggggggg")
				.param("role", "hhhhhhhh")).andReturn();
		
		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(6)
	@WithMockUser
	void deleteUser() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/delete/" + createdTestUser.getId())).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
