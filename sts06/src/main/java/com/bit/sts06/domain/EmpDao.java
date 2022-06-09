package com.bit.sts06.domain;

import java.sql.*;
import java.util.*;

public interface EmpDao {

	List<EmpVo> findAll() throws Exception;
	EmpVo findOne(int idx) throws Exception;
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	
}
