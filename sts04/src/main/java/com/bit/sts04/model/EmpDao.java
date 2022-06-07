package com.bit.sts04.model;

import java.sql.*;
import java.util.*;

public interface EmpDao<T> {
	List<T> findAll() throws SQLException;
	T findOne(int idx) throws SQLException;
	void insertOne(T obj) throws SQLException;
	int updateOne(T obj) throws SQLException;
	int deleteOne(int idx) throws SQLException;
}
