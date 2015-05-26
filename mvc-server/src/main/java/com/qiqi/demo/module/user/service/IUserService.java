package com.qiqi.demo.module.user.service;

import java.util.List;

import com.qiqi.demo.pojo.User;

/**
 * 用户service接口
 * 
 * @author wenyong
 *
 */
public interface IUserService {
	/**
	 * User列表
	 * 
	 * @return 全部User记录
	 */
	List<User> list();
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	User getById(Integer id);

	/**
	 * 新增User
	 * 
	 * @param user
	 * @return id 新增的id
	 */
	User add(User user);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	void deleteById(Integer id);

	/**
	 * 更新
	 * 
	 * @param u
	 */
	void update(User u);
	
	/**
	 * 测试spring实务管理
	 */
	void testTransaction(); 

}
