package com.bit.sts06.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test1() throws Exception {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		cnt=empDao.findAll().size();
		assertNotEquals(0, cnt);
		log.debug("size : "+cnt);
		
	}
	
	@Test
	public void test2() throws Exception{
		assertNotNull(empDao);
		try {
			log.debug(empDao.findOne(995).toString());
			fail();
		} catch (Exception e) {
		}
		assertNotNull(empDao.findOne(1000));		
	}

	@Test
//	@RunWith로 테스트 실행시 디폴트로 롤백
//	@Transactional
	public void test3() throws Exception {
		assertNotNull(empDao);
		EmpVo target=new EmpVo(700,1,"test","tester",null);
//		int before=empDao.findAll().size();
		empDao.insertOne(target);
//		assertEquals(before+1, empDao.findAll().size());
		assertEquals(1,empDao.updateOne(target));
		assertEquals(1,empDao.deleteOne(target.getEmpno()));
	}
	
	@Test
	public void test4() throws Exception{
		log.debug("size : "+empDao.findSize());
	}
	
	
}
