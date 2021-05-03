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

import com.nnk.springboot.domain.Rule;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RuleControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	static private Rule createdTestRule;
	static private ArrayList<Rule> ruleList;
	
	@Test
	@Order(1)
	@WithMockUser
	void addRuleForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ruleName/add")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/ruleName/validate")
				.param("name", "aaaaaaaa")
				.param("description", "bbbbbbbb")
				.param("json", "cccccccc")
				.param("template", "dddddddd")
				.param("sqlStr", "eeeeeeee")
				.param("sqlPart", "ffffffff")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ruleName/list")).andReturn();
		
		ruleList = ((ArrayList<Rule>) mvcResult.getModelAndView().getModel().get("ruleList"));
		createdTestRule = ruleList.get(ruleList.size()-1);
		
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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ruleName/update/" + createdTestRule.getId())).andReturn();
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(5)
	@WithMockUser
	void updateRule() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/ruleName/update/" + createdTestRule.getId())
				.param("name", "gggggggg")
				.param("description", "hhhhhhhh")
				.param("json", "iiiiiiii")
				.param("template", "jjjjjjjj")
				.param("sqlStr", "kkkkkkkk")
				.param("sqlPart", "llllllll")).andReturn();
		
		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(6)
	@WithMockUser
	void deleteRule() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ruleName/delete/" + createdTestRule.getId())).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
