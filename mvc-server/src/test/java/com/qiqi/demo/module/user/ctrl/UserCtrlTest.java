package com.qiqi.demo.module.user.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.fastjson.JSON;
import com.qiqi.demo.pojo.User;



//import static
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:**/rest-servlet.xml"),
		@ContextConfiguration(name = "child", locations = "classpath:META-INF/spring-app.xml") })
@TestExecutionListeners(inheritListeners = false, listeners = {
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class })
@EnableWebMvc
public class UserCtrlTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

	@Before
	public void configured() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testAdd() throws Exception {

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetail() throws Exception {
		String username = "new";
		String gender = "3";
		String trueName = "new123";
		User user = new User();
        user.setUsername(username);
        user.setGender(gender);
        user.setTrueName(trueName);
        
        String jsonStr = JSON.toJSONString(user);

        System.out.println(jsonStr);

        ResultActions s = mockMvc.perform(get("/user/detail/{id}", 3))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.data", is(jsonStr)))
                .andExpect(content().string(jsonStr))
                .andExpect(jsonPath("$.data.username", is(username)))
                .andExpect(jsonPath("$.data.gender", is(gender)))
                .andExpect(jsonPath("$.data.trueName", is(trueName)));
        s.andDo(print());
	}

	@Test
	public void testList() throws Exception {
		this.mockMvc.perform(
				post("/user/list", "json").characterEncoding("UTF-8")
						.contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk())
				.andDo(print());
	}

}
