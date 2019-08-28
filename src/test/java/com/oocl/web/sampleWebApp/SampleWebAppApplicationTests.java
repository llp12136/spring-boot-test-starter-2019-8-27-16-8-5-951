package com.oocl.web.sampleWebApp;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleWebAppApplicationTests {



	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void getTest() throws Exception {
//		this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello World")));
//	}
//
//	@Test
//	public void postTest() throws Exception {
//		this.mockMvc.perform(post("/user")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello World")));
//	}
//post
	@Test
	public void should_return_201_status_when_create_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = post("/user").content("{\"username\":\"xiaoming\"}").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions result = mockMvc.perform(input);
		//Then
		result
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated());
	}
//GET
	@Test
	public void should_return_ok_and_content_when_query_all_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user");
		//When
		ResultActions performResult = mockMvc.perform(requestBuilder);
		//Then
		performResult
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[{\"id\":\"001\",\"name\":\"xiaoming\"}]"));
	}
	//put
	@Test
	public void should_return_201_status_when_update_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = post("/user").content("{\"username\":\"xiaohong\"}").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions result = mockMvc.perform(input);
		//Then
		result
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated());
	}
}