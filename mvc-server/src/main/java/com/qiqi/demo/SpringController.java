package com.qiqi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvc")
public class SpringController {
	public static Logger LOG = LoggerFactory.getLogger(SpringController.class);

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String getGreeting(@PathVariable String name) {
		String result="Hello " + name;
		LOG.debug("Client Parameter:" + name);
		return result;
	}
}
