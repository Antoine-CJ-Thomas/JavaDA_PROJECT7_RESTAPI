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

import com.nnk.springboot.domain.Bid;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BidControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	static private Bid createdTestBid;
	static private ArrayList<Bid> bidList;
	
	@Test
	@Order(1)
	@WithMockUser
	void addBidForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/bidList/add")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/bidList/validate")
				.param("account", "aaaaaaaa")
				.param("type", "bbbbbbbb")
				.param("bidQuantity", "3.0")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/bidList/list")).andReturn();
		
		bidList = ((ArrayList<Bid>) mvcResult.getModelAndView().getModel().get("bidList"));
		createdTestBid = bidList.get(bidList.size()-1);
		
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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/bidList/update/" + createdTestBid.getBidListId())).andReturn();
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(5)
	@WithMockUser
	void updateBid() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/bidList/update/" + createdTestBid.getBidListId())
				.param("account", "cccccccc")
				.param("type", "dddddddd")
				.param("bidQuantity", "3.0")).andReturn();
		
		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(6)
	@WithMockUser
	void deleteBid() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/bidList/delete/" + createdTestBid.getBidListId())).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
