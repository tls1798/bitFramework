package com.bit.sts06.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmpDaoTest {
//	Logger log = Logger.getLogger(getClass());
//	Logger log = LoggerFactory.getLogger(EmpDaoTest.class);
	static EmpDao empDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		empDao=ac.getBean(EmpDao.class);
	}
	private int cnt;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		cnt=empDao.findAll().size();
		assertNotEquals(0, cnt);
		log.debug("size : "+cnt);
	}

}
