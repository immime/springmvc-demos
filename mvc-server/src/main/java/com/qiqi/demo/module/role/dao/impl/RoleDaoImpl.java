package com.qiqi.demo.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qiqi.demo.module.role.dao.IRoleDao;
import com.qiqi.demo.pager.EntityResultSet;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pojo.Role;

/**
 * 角色dao实现
 * 
 * @author wenyong
 *
 */
@Repository
public class RoleDaoImpl implements IRoleDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Role> list() {
		String sql = "SELECT * FROM `t_role` t";
		jdbcTemplate.query(sql, new RoleRowMapper());
		return null;
	}

	/*
	 * 表`t_role`的结果集封装:ResultSet -> Entity
	 */
	private class RoleRowMapper implements RowMapper<Role> {
		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role r = new Role();
			r.setId(rs.getString("id"));
			r.setName(rs.getString("name"));
			r.setDesc(rs.getString("desc"));
			r.setIcon(rs.getString("icon"));
			return r;
		}
	}

	@Override
	public Role getById(String id) {
		String sql = "SELECT * FROM `t_role` t WHERE t.id = ?";
		List<Role> list = jdbcTemplate.query(sql, new Object[] { id },
				new RoleRowMapper());
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public String add(final Role r) {
		String id = UUID.randomUUID().toString();
		final String sql = "INSERT INTO `t_role` (id, name, desc, icon) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { id, r.getName(), r.getDesc(), r.getIcon() });
		return id;
	}

	@Override
	public void deleteById(String id) {
		String sql = "DELETE FROM `t_role` WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Role r) {
		String sql = "UPDATE `t_role` t SET t.name=?, t.desc=?, t.icon=? WHERE t.id=?";
		Object[] args = new Object[] { r.getName(), r.getDesc(), r.getIcon(),
				r.getId() };
		jdbcTemplate.update(sql, args);
	}

	@Override
	public EntityResultSet<Role> query(PagingCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
