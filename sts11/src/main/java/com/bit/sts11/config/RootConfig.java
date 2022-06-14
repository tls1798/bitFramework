package com.bit.sts11.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.Driver;

@Configuration
@MapperScan("com.bit.sts11.model")
public class RootConfig {
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Driver.class.getTypeName());
		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
		dataSource.setUsername("user01");
		dataSource.setPassword("1234");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(getDataSource());
		return factory.getObject();
	}
	
//	@Bean
//	public SqlSessionFactory getSqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//		factory.setDataSource(getDataSource());
//		Resource[] resource = new Resource[1];
//		resource[0] = new ClassPathResource("/mapper/deptMapper.xml");
//		factory.setMapperLocations(null);
//		return factory.getObject();
//	}
//	
//	@Bean
//	public SqlSession getSqlSession() throws Exception {
//		return new SqlSessionTemplate(getSqlSessionFactory());
//	}
	
//	@Bean
//	public JdbcTemplate geJdbcTemplate() {
//		JdbcTemplate jdbcTemplate=new JdbcTemplate();
//		jdbcTemplate.setDataSource(getDataSource());
//		
//		return jdbcTemplate;
//	}
}
