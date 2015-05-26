package com.qiqi.demo.module.role.service;

import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pojo.Role;

public interface IRoleService {
	
	/**
	 * 查询
	 * @param criteria 分页参数对象
	 * @return 可分页结果集
	 */
	EntityResultSet<Role> query(PagingCriteria criteria);
	
}
