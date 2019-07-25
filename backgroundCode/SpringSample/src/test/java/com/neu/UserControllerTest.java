package com.neu;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class UserControllerTest extends BaseTest{

	@Test
	public void testIsLogin() throws Exception{
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user/login")
				.param("cUsername", "admin")
				.param("cPwd", "admin"))
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	/**
	 * 获取用户列表
	 */
	@Test
	public void testGetUserList()throws Exception{
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/user/getUserList"))
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void testInsertUser()throws Exception{
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user/insertUser")
				.param("cUsername", "admin1")
				.param("cPwd", "admin1"))
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	@Test
	public void deleteUser()throws Exception{
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user/delete")
				.param("cId", "1"))
				
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	@Test
	public void testUpdateUser()throws Exception{
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user/updateUser")
				.param("cId", "2")
				.param("cUsername", "admin2")
				.param("cPwd", "admin2"))
				
				.andReturn();
				
				
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
}
