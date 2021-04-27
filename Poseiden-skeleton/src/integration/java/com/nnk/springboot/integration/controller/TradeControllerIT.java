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

import com.nnk.springboot.domain.Trade;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TradeControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	static private Trade createdTestTrade;
	static private ArrayList<Trade> tradeList;
	
	@Test
	@Order(1)
	@WithMockUser
	void addTradeForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/trade/add")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/trade/validate")
				.param("account", "aaaaaaaa")
				.param("type", "bbbbbbbb")
				.param("buyQuantity", "3.0")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/trade/list")).andReturn();
		
		tradeList = ((ArrayList<Trade>) mvcResult.getModelAndView().getModel().get("tradeList"));
		createdTestTrade = tradeList.get(tradeList.size()-1);
		
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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/trade/update/" + createdTestTrade.getTradeId())).andReturn();
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(5)
	@WithMockUser
	void updateTrade() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/trade/update/" + createdTestTrade.getTradeId())
				.param("account", "cccccccc")
				.param("type", "dddddddd")
				.param("buyQuantity", "6.0")).andReturn();
		
		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(6)
	@WithMockUser
	void deleteTrade() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/trade/delete/" + createdTestTrade.getTradeId())).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
