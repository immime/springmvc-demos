package com.qiqi.demo.module.user.ctrl;

//import static
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.qiqi.demo.pojo.User;


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
