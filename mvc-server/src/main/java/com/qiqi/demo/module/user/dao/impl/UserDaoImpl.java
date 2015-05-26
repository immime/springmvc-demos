package com.qiqi.demo.module.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.qiqi.demo.module.user.dao.IUserDao;
import com.qiqi.demo.pojo.User;

/**
 * 用户dao实现
 * 
 * @author wenyong
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> list() {
		String sql = "SELECT u.id, u.username, u.password, u.gender, u.trueName FROM `t_user` u";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public User getById(Integer id) {
		String sql = "SELECT u.id, u.username, u.password, u.gender, u.trueName FROM `t_user` u WHERE u.id=?";
		return jdbcTemplate.query(sql, new Object[] { id },
				new ResultSetExtractor<User>() {

					@Override
					public User extractData(ResultSet rs) throws SQLException,
							DataAccessException {
						if (rs.next()) {
							User u = new User();
							u.setId(rs.getInt("id"));
							u.setUsername(rs.getString("username"));
							u.setPassword(rs.getString("password"));
							u.setGender(rs.getString("gender"));
							u.setTrueName(rs.getString("trueName"));
							return u;
						}
						return null;
					}

				});
	}

	private class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setGender(rs.getString("gender"));
			u.setTrueName(rs.getString("trueName"));
			return u;
		}
	}

	@Override
	public User add(final User u) {
		final String sql = "INSERT INTO `t_user` (username, password, gender, trueName) VALUES (?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    	            PreparedStatement pst =
    	                con.prepareStatement(sql, new String[] {"id"});
    	            pst.setString(1, u.getUsername());
    	            pst.setString(2, u.getPassword());
    	            pst.setString(3, u.getGender());
    	            pst.setString(4, u.getTrueName());
    	            return pst;
    	        }
    	    },
    	    keyHolder);
    	
    	Integer id = keyHolder.getKey().intValue();
		 u.setId(id);
		return u;
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM `t_user` WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE `t_user` u SET u.username=?, u.password=?, u.gender=?, u.trueName=? WHERE u.id=?";
		Object[] args = new Object[] { u.getUsername(), u.getPassword(),
				u.getGender(), u.getTrueName(), u.getId() };
		jdbcTemplate.update(sql, args);

	}

}
