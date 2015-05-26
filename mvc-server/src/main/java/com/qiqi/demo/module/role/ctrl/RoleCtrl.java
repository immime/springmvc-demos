package com.qiqi.demo.module.role.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiqi.demo.datatables.DataTableUtils;
import com.qiqi.demo.datatables.TableParam;
import com.qiqi.demo.module.role.service.IRoleService;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pager.WebResultSet;
import com.qiqi.demo.pojo.Role;

@RestController
@RequestMapping("/role")
public class RoleCtrl {

	@Autowired
	private IRoleService service;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public WebResultSet<Role> getCustomers(@TableParam PagingCriteria criteria) {
		EntityResultSet<Role> roles = this.service.query(criteria);
		return DataTableUtils.getWebResultSet(criteria, roles);
	}
	
}
