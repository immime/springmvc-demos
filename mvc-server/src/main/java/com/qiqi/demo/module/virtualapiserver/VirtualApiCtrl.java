package com.qiqi.demo.module.virtualapiserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiqi.demo.pojo.User;

@RestController
@RequestMapping("/vitualapi")
public class VirtualApiCtrl {

	@RequestMapping(value = "/login")
	public User login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		User user = new User();
		user.setUsername(username);
		user.setTrueName("John Wen");
		user.setGender("男");
		return user;
	}

}
