package com.bit.emp.model;

import java.util.*;
import java.sql.*;

public interface EmpDao {
	
	List<EmpVo> selectAll() throws SQLException;
	EmpVo selectOne(int num) throws SQLException;
	int deleteOne(int num) throws SQLException;
	int updateOne(EmpVo bean) throws SQLException;
	void insertOne(EmpVo bean) throws SQLException;
}
