package com.qiqi.demo.module.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qiqi.demo.module.user.service.IUserService;
import com.qiqi.demo.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-app.xml" })
// 是否回滚：defaultRollback = true 回滚insert、update、delete操作
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class UserServiceImplTest {
	
	@Resource
	private IUserService service;
	
	@Test
	public void testTransaction() {
		service.testTransaction();
	}
	
	@Test
	public void testList() {
		List<User> list = service.list();
		for (User user : list) {
			System.out.println(ToStringBuilder.reflectionToString(user));
		}
		System.out.println("Result:" + list.size());
	}
	
	@Test
	public void testGetById() {
		int id = 3;
		User user = service.getById(id);
		if(user != null) {
			System.out.println(ToStringBuilder.reflectionToString(user));
		} else {
			System.out.println("Can not find record where id = " + id);
		}
	}
	
	@Test
	public void testAdd() {
		User u = new User();
		u.setUsername("test01");
		u.setPassword("test123");
		u.setGender("2");
		u.setTrueName("张三");
		service.add(u);
		System.out.println("insert success!");
	}
	
	@Test
	public void testDeleteById() {
		int id = 1;
		service.deleteById(id);
		System.out.println("delete User by id = " + id);
	}
	
	@Test
	public void testUpdate() {
		int id = 3;
		User u = new User();
		u.setId(id);
		u.setUsername("new");
		u.setPassword("new123");
		u.setGender("3");
		u.setTrueName("更新");
		service.update(u);
		System.out.println("update user by id=" + id);
	}

}
