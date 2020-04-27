package com.bank.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bank.demo.entity.Result;
import com.bank.demo.entity.TestEntity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	
class DemoApplicationTests extends AbstractApplicationTests {

	@Test
	void contextLoads() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/index/login")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		String ret = response.getContentAsString();
		assertEquals(status, 200);
		if (200 == status) {
			
			Gson json = new Gson();
			TestEntity entity = json.fromJson(ret , TestEntity.class);
			System.out.println(entity.getMap());
			System.out.println(entity.getMain());
			System.out.println(entity.getEntity().getMap());
			System.out.println(entity.getEntity().getMain());
			System.out.println(response.getContentAsString());
			assertEquals("main".equals(entity.getMap()),true,"1232");
			assertEquals("data".equals(entity.getMain()),true,"1233");
			assertEquals("main".equals(entity.getEntity().getMap()),true,"1234");
			assertEquals("data".equals(entity.getEntity().getMain()),true,"1235");
			
		} 

	}

	@Test
	void getHashMap() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/index/doLogin")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		String ret = response.getContentAsString();
		assertEquals(status, 200);
		if (200 == status) {
			
			Gson json = new Gson();
			JsonObject jsonObject = json.fromJson(ret , JsonObject.class);
			System.out.println(jsonObject.get("map"));
			System.out.println("main".equals(jsonObject.get("map")));
			System.out.println(response.getContentAsString());
			assertEquals(jsonObject.get("map").toString().contains("main"),true,"1232");
			assertEquals(jsonObject.get("data").toString().contains("data"),true,"1233");
			
		} 

	}

	@Test
	void postDoLogin() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/index/doLogin")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		String ret = response.getContentAsString();
		assertEquals(status, 200);
		if (200 == status) {
			

			Gson json = new Gson();
			Result results = json.fromJson(ret, Result.class);
			// TestEntity entity = (TestEntity)results.getData();
			System.out.println(results.toString());
			System.out.println(results.getCode());
			System.out.println(results.getMsg());
			System.out.println(results.getData());
			System.out.println(response.getContentAsString());
			assertEquals(results.getCode() == 0,true,"1229");
			assertEquals(results.getMsg().equals("success"),true,"1230");
			// assertEquals("main".equals(entity.getMap()),true,"1232");
			// assertEquals("data".equals(entity.getMain()),true,"1233");
			
		} 

	}

	@Test
	void index() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/index/login")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		String ret = response.getContentAsString();
		assertEquals(status, 200);
		if (200 == status) {
			assertEquals("/index/login", ret, "1234");
		}

	}

}
