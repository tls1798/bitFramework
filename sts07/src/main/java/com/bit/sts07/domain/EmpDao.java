package com.bit.sts07.domain;

import java.sql.*;
import java.util.*;

public interface EmpDao {	
	List<EmpVo> findAll() throws SQLException;
	EmpVo findOne(int idx) throws SQLException;
	void insertOne(EmpVo bean) throws SQLException;
	int updateOne(EmpVo bean) throws SQLException;
	int deleteOne(int idx) throws SQLException;
	int allSize() throws SQLException;
}
