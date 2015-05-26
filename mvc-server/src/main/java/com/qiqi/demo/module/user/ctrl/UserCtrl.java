package com.qiqi.demo.module.user.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qiqi.demo.module.user.service.IUserService;
import com.qiqi.demo.pojo.User;

@RestController
@RequestMapping("/user")
public class UserCtrl {

	@Autowired
	private IUserService service;

	@RequestMapping(value = "/create")
	public User create(@RequestBody User u) {
		return service.add(u);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/update")
	public void update(@RequestBody User u) {
		service.update(u);
	}

	@RequestMapping(value = "/detail/{id}")
	public User detail(@PathVariable Integer id) {
		return service.getById(id);
	}

	@RequestMapping(value = "/list")
	public List<User> list() {
		List<User> list = service.list();
		return list;
	}

}
