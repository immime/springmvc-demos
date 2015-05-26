package com.qiqi.demo.module.user.dao;

import java.util.List;

import com.qiqi.demo.pojo.User;

/**
 * 用户dao接口
 * 
 * @author wenyong
 *
 */
public interface IUserDao {
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
	 * @return 新增user的id
	 */
	User add(final User user);

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

}
