package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpDaoTest {
	EmpDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws SQLException {
		dao=new EmpDao();
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertTrue(dao.selectAll().size()>0);
	}
	
	@Test
	public void testInsertOne() throws SQLException {
//		dao.conn.setAutoCommit(false);
		EmpVo target=new EmpVo(1000,1000,"test","test");
		dao.insertOne(target);
		
//		dao=new EmpDao();
//		dao.conn.setAutoCommit(false);
//		target=new EmpVo(1000,1000,"test","test");
//		try {
//			dao.insertOne(target);
//			assertFalse(true);
//		} catch (Exception e) {
//			assertFalse(false);
//		}
	}
	
	@Test
	public void testDeleteOne() throws SQLException {
		assertSame(1, dao.deleteOne(1010));
	}
	
}
