package com.bit.frame.model;

import java.util.*;
import java.sql.SQLException;

public interface EmpDao<T> {
	List<T> findAll() throws SQLException;
	T findOne(int num) throws SQLException;
	void insertOne(T bean) throws SQLException;
	int updateOne(T bean) throws SQLException;
	int deleteOne(int num) throws SQLException;
}
