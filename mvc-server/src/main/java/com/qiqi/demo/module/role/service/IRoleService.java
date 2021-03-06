package com.qiqi.demo.module.role.service;

import com.qiqi.demo.datatables.DataTablesCriteria;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.PageResultSet;
import com.qiqi.demo.pager.WebResultSet;
import com.qiqi.demo.pojo.Role;

public interface IRoleService {
	
	/**
	 * 新增
	 * @param r
	 * @return
	 */
	Role add(Role r);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(String id);
	
	/**
	 * 更新
	 * @param r
	 */
	void update(Role r);
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	Role getById(String id);
	
	/**
	 * 查询
	 * @param criteria 分页参数对象
	 * @return 可分页结果集
	 */
	PageResultSet<Role> query(PagingCriteria criteria);

	/**
	 * 查询
	 * @param table datatables对象
	 * @return
	 */
	WebResultSet<Role> query(DataTablesCriteria table);
	
}
