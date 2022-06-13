package com.bit.sts08.repository;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts08.domain.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpDaoTest {

	@Autowired
	EmpDao empDao;
	
	@Test
	public void test1FindAll() {
		assertNotNull(empDao.findAll());
	}
	
	@Test
	public void test3FindOne() {
		assertNotNull(empDao.findOne(999));
		log.debug(empDao.findOne(999).toString());
	}
	
	
	@Transactional
	@Test
	public void test2InsertOne() {
		Emp emp = new Emp(701,777,"test1","test2",null);
		assertNotEquals(0, empDao.insertOne(emp));
		log.debug(empDao.findOne(emp.getEmpno()).toString());
	}
	
}
