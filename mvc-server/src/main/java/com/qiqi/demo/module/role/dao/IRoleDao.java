package com.qiqi.demo.module.role.dao;

import java.util.List;

import com.qiqi.demo.pager.PageResultSet;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pojo.Role;

/**
 * 角色dao接口
 * @author wenyong
 *
 */
public interface IRoleDao {
	/**
	 * Role列表
	 * 
	 * @return 全部Role记录
	 */
	List<Role> list();
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	Role getById(String id);

	/**
	 * 新增Role
	 * 
	 * @param id
	 * @return 新增role的id
	 */
	Role add(Role id);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 更新
	 * 
	 * @param r
	 */
	void update(Role r);
	
	/**
	 * 获取记录总数
	 * @return
	 */
	int getTotalCount();
	
	/**
	 * 获取dataTable列表
	 * @param pager
	 * @return
	 */
	PageResultSet<Role> query(PagingCriteria criteria);
}
