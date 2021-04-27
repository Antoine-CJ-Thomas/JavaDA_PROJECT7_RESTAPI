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

import com.nnk.springboot.domain.CurvePoint;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CurvePointControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	static private CurvePoint createdTestCurvePoint;
	static private ArrayList<CurvePoint> curvePointList;
	
	@Test
	@Order(1)
	@WithMockUser
	void addCurvePointForm() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/curvePoint/add")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/curvePoint/validate")
				.param("curveId", "1")
				.param("term", "2.0")
				.param("value", "3.0")).andReturn();

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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/curvePoint/list")).andReturn();
		
		curvePointList = ((ArrayList<CurvePoint>) mvcResult.getModelAndView().getModel().get("curvePointList"));
		createdTestCurvePoint = curvePointList.get(curvePointList.size()-1);
		
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
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/curvePoint/update/" + createdTestCurvePoint.getId())).andReturn();
		
		// THEN
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(5)
	@WithMockUser
	void updateCurvePoint() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/curvePoint/update/" + createdTestCurvePoint.getId())
				.param("curveId", "2")
				.param("term", "3.0")
				.param("value", "4.0")).andReturn();
		
		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}

	@Test
	@Order(6)
	@WithMockUser
	void deleteCurvePoint() throws Exception {

		// GIVEN
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		// WHEN
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/curvePoint/delete/" + createdTestCurvePoint.getId())).andReturn();

		// THEN
		assertEquals(302, mvcResult.getResponse().getStatus());
	}
}
