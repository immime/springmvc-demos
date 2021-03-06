package com.qiqi.demo.module.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiqi.demo.datatables.DataTableUtils;
import com.qiqi.demo.datatables.DataTablesCriteria;
import com.qiqi.demo.module.role.dao.IRoleDao;
import com.qiqi.demo.module.role.service.IRoleService;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.PageResultSet;
import com.qiqi.demo.pager.WebResultSet;
import com.qiqi.demo.pojo.Role;


@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao dao;

	@Override
	public Role add(Role r) {
		return dao.add(r);
	}

	@Override
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	@Override
	public void update(Role r) {
		dao.update(r);
	}

	@Override
	public Role getById(String id) {
		return dao.getById(id);
	}

	@Override
	public PageResultSet<Role> query(PagingCriteria criteria) {
		return dao.query(criteria);
	}

	@Override
	public WebResultSet<Role> query(DataTablesCriteria table) {
		// TODO Auto-generated method stub
		PagingCriteria criteria = DataTableUtils.parseReqParameter(table);
		PageResultSet<Role> roles = dao.query(criteria);
		 WebResultSet<Role> result = DataTableUtils.getWebResultSet(criteria, roles);
		return result;
	}

}
