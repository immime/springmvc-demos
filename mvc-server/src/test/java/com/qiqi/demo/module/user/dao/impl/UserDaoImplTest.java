package com.qiqi.demo.module.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qiqi.demo.module.user.dao.IUserDao;
import com.qiqi.demo.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-app.xml"})
// 是否回滚：defaultRollback = true 回滚insert、update、delete操作
@TransactionConfiguration(defaultRollback = false)  
@Transactional
public class UserDaoImplTest {

	@Resource
	private IUserDao dao;
	
	@Test
	public void testList() {
		List<User> list = dao.list();
		for (User user : list) {
			System.out.println(ToStringBuilder.reflectionToString(user));
		}
		System.out.println("Result:" + list.size());
	}
	
	@Test
	public void testGetById() {
		int id = 3;
		User user = dao.getById(id);
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
		dao.add(u);
		System.out.println("insert success!");
	}
	
	@Test
	public void testDeleteById() {
		int id = 1;
		dao.deleteById(id);
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
		dao.update(u);
		System.out.println("update user by id=" + id);
	}
	
}
