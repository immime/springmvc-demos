package com.qiqi.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration
@ContextHierarchy({  
        @ContextConfiguration(name = "parent", locations = "classpath:**/rest-servlet.xml"),  
        @ContextConfiguration(name = "child", locations = "classpath:META-INF/spring-app.xml")  
})
public class SpringControllerTest {
	
    @Before
    public void configured() {
    }

	@Test
	public void testGetGreeting() {
		
	}

}
