package com.qiqi.demo.module.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiqi.demo.module.user.dao.IUserDao;
import com.qiqi.demo.module.user.service.IUserService;
import com.qiqi.demo.pojo.User;

/**
 * 用户service实现
 * @author wenyong
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;
	
	@Override
	public List<User> list() {
		return dao.list();
	}

	@Override
	public User getById(Integer id) {
		return dao.getById(id);
	}
	
	@Transactional
	@Override
	public User add(User user) {
		return dao.add(user);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	@Transactional
	@Override
	public void update(User u) {
		dao.update(u);
	}

	@Transactional
	@Override
	public void testTransaction() {
		// TODO 仅用于测试事务
		User user = new User();
		user.setUsername("haha3");
		user.setPassword("11111");
		dao.add(user );
		// exception
		Integer.parseInt("a");
		user.setUsername("haha3");
		user.setPassword("22222");
		dao.add(user);
		
	}


}
