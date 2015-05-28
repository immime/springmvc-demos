package com.qiqi.demo.module.role.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiqi.demo.datatables.DataTableUtils;
import com.qiqi.demo.module.role.service.IRoleService;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.WebResultSet;
import com.qiqi.demo.pojo.Role;

@RestController
@RequestMapping("/role")
public class RoleCtrl {

	private static final Logger logger = LoggerFactory.getLogger(RoleCtrl.class);

	@Autowired
	private IRoleService service;
	
	@RequestMapping(value = "/add")
	public Role add(@RequestBody Role r) {
		return service.add(r);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/update")
	public void update(@RequestBody Role r) {
		service.update(r);
	}

	@RequestMapping(value = "/detail/{id}")
	public Role detail(@PathVariable String id) {
		return service.getById(id);
	}

	@RequestMapping(value = "/list")
	public WebResultSet<Role> list(@RequestBody PagingCriteria criteria) {
		EntityResultSet<Role> roles = this.service.query(criteria);
		return DataTableUtils.getWebResultSet(criteria, roles);
	}

}
