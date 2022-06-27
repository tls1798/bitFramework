package com.bit.sts32.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/","/login","/logout").permitAll();
//		http.authorizeHttpRequests().antMatchers("/hello").authenticated();
//		http.authorizeHttpRequests().antMatchers("/").authenticated();
//		http.authorizeHttpRequests().anyRequest().authenticated();
//		권한에 따른 접근
		http.authorizeHttpRequests().anyRequest().hasAnyRole("ADMIN","USER");
		http.formLogin().loginPage("/login");
	}
	
	@Autowired
	DataSource dataSource;

	
//	insert into users (username, password, enabled) values (?,?,?); 
//	CREATE TABLE `users` (
//	`username` VARCHAR(50) NOT NULL,
//	`password` VARCHAR(100) NOT NULL,
//	`enabled` BIT NULL DEFAULT NULL,
//	PRIMARY KEY (`username`)
//	)
//	COLLATE='utf8mb4_0900_ai_ci';

//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//	  builder.jdbcAuthentication().dataSource(dataSource).withUser("user01")
//	    .password(getPasswordEncoder().encode("1234")).roles("USER");
//	}
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	db에 있는 내용으로 로그인
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	    	.jdbcAuthentication()
	    	.dataSource(dataSource)
	    	.usersByUsernameQuery("select username, password, enabled from users where username=?")
	    	.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
	}
}
