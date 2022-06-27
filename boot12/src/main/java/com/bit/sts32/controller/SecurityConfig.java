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
		http.authorizeHttpRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/login");
	}
	
	@Autowired
	DataSource dataSource;

//	[insert into users (username, password, enabled) values (?,?,?)]; 
//	Table 'xe.users' doesn't exist

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
	  builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
	    .password(getPasswordEncoder().encode("secret")).roles("USER");
	}
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
