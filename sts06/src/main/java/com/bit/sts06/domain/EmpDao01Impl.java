package com.bit.sts06.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDao01Impl implements EmpDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<EmpVo> mapper = new RowMapper<EmpVo>() {
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			log.debug("rownum: " + rowNum);
			return new EmpVo(
					rs.getInt("empno"), rs.getInt("sal"),rs.getString("ename"),
					rs.getString("job"),rs.getTimestamp("hiredate")
					);
		}
	};
	
	@Override
	public List<EmpVo> findAll() throws Exception {
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public EmpVo findOne(int idx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(EmpVo bean) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOne(EmpVo bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
