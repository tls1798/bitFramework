package com.bit.sts08;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestBean {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() throws SQLException{
		assertNotNull(dataSource);
		dataSource.getConnection().close();
	}

}
