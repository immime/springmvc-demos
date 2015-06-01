package com.qiqi.demo.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qiqi.demo.module.role.dao.IRoleDao;
import com.qiqi.demo.pager.PageResultSet;
import com.qiqi.demo.pager.PageSqlQueryer;
import com.qiqi.demo.pager.PagingCriteria;
import com.qiqi.demo.pager.SearchCondition;
import com.qiqi.demo.pager.SearchOperator;
import com.qiqi.demo.pager.SearchType;
import com.qiqi.demo.pager.SortField;
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
	public Role add(final Role r) {
		String id = UUID.randomUUID().toString();
		final String sql = "INSERT INTO `t_role` (id, name, summary, icon) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { id, r.getName(),
				r.getSummary(), r.getIcon() });
		r.setId(id);
		return r;
	}

	@Override
	public void deleteById(String id) {
		String sql = "DELETE FROM `t_role` WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Role r) {
		String sql = "UPDATE `t_role` t SET t.name=?, t.summary=?, t.icon=? WHERE t.id=?";
		Object[] args = new Object[] { r.getName(), r.getSummary(),
				r.getIcon(), r.getId() };
		jdbcTemplate.update(sql, args);
	}

	@Override
	public int getTotalCount() {
		String sql = "SELECT COUNT(1) FROM `t_role`";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public PageResultSet<Role> query(PagingCriteria criteria) {
		SearchCondition searchCondition = criteria.getSearchCondition();
		List<SortField> sortFields = criteria.getSortFields();

		String select = "SELECT * FROM `t_role` t";
		StringBuilder sql = new StringBuilder(select);

		if (searchCondition != null) {
			StringBuilder where = new StringBuilder(" WHERE ");
			String cnd = searchCondition.getCnd();
			List<String> fields = searchCondition.getFields();
			SearchOperator searchOperator = searchCondition.getSearchOperator();
			SearchType searchType = searchCondition.getSearchType();
			if (CollectionUtils.isNotEmpty(fields)) {
				if (searchType.equals(SearchType.EQUALS)) {
					for (String field : fields) {
						where.append(field).append(" = ").append("'")
								.append(cnd).append("' ")
								.append(searchOperator);
					}
				}
				if (searchType.equals(SearchType.LIKE)) {
					for (String field : fields) {
						where.append(field).append(" LIKE").append(" '%")
								.append(cnd).append("%' ")
								.append(searchOperator);
					}
					
				}
				where.delete(where.length()
						- searchOperator.toString().length(),
						where.length());
				sql.append(where);
			}
		}

		// ORDER
		if (CollectionUtils.isNotEmpty(sortFields)) {
			StringBuilder sort = new StringBuilder(" ORDER BY ");
			for (SortField sf : sortFields) {
				sort.append(sf.getField()).append(" ")
						.append(sf.getDirection()).append(",");
			}
			sort.deleteCharAt(sort.length() - 1);
			sql.append(sort);
		}
		
		// LIMIT
		PageSqlQueryer psq = new PageSqlQueryer(criteria);
		sql.append(" LIMIT ").append(psq.getLimitStartIndex()).append(", ")
				.append(psq.getLimitOffset());
		
		PageResultSet<Role> sets = new PageResultSet<Role>();
		List<Role> rows = new ArrayList<Role>();
		Integer iTotalRecords = 0;
		Integer iTotalDisplayRecords = 0;

		rows = jdbcTemplate.query(sql.toString(), new RoleRowMapper());
		iTotalRecords = this.getTotalCount();
		iTotalDisplayRecords = rows.size();

		sets.setRows(rows);
		sets.setTotalDisplayRecords(iTotalDisplayRecords.longValue());
		sets.setTotalRecords(iTotalRecords.longValue());
		return sets;
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
			r.setSummary(rs.getString("summary"));
			r.setIcon(rs.getString("icon"));
			return r;
		}
	}

}
