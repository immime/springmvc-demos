package com.qiqi.demo.module.role.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiqi.demo.datatables.DataTableUtils;
import com.qiqi.demo.module.role.service.IRoleService;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.SortDirection;
import com.qiqi.demo.pager.WebResultSet;
import com.qiqi.demo.pojo.Role;
import com.qiqi.demo.pojo.User;

@RestController
@RequestMapping("/role")
public class RoleCtrl {

	private static final Logger logger = LoggerFactory.getLogger(RoleCtrl.class);

	@Autowired
	private IRoleService service;

	@RequestMapping(value = "/get")
	public WebResultSet<Role> getCustomers(@RequestBody PagingCriteria criteria) {
		EntityResultSet<Role> roles = this.service.query(criteria);
		return DataTableUtils.getWebResultSet(criteria, roles);
	}
	
	@RequestMapping(value = "/test")
	public User create(@RequestBody User u) {
		System.out.println(u.toString());
		return u;
	}

}
