package com.bit.sts29.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		csrf 사용 안할 때
		http.csrf().disable();
//		홈 누구나 접근 가능
		http.authorizeRequests().antMatchers("/", "/home").permitAll();
//		모든 페이지는 인증을 받아야 함 -> 로그인 해야함
		http.authorizeRequests().anyRequest().authenticated();
//		로그인 누구나 접근 가능
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();
//		로그아웃 누구나 접근 가능
		http.logout().permitAll();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user =
				 User.builder() //withDefaultPasswordEncoder()
					.username("user")
					.password(getPasswordEncoder().encode("password"))
					.roles("USER")
					.build();
			System.out.println(user);
			return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
