package com.qiqi.demo.module.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiqi.demo.module.role.dao.IRoleDao;
import com.qiqi.demo.module.role.service.IRoleService;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pojo.Role;


@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao dao;
	

	@Override
	public EntityResultSet<Role> query(PagingCriteria criteria) {
		// TODO Auto-generated method stub
		return dao.query(criteria);
	}

}
