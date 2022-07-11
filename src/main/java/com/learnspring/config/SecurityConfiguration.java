package com.learnspring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	{
		try {
			
			PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
			/*
			auth.inMemoryAuthentication().withUser("ravi").password(encoder.encode("1")).roles("manager")
			.and().withUser("hari").password(encoder.encode("2")).roles("cashier")
			.and().withUser("ashok").password(encoder.encode("3")).roles("admin");
			*/
			auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema().withUser("ravi").password(encoder.encode("1")).roles("manager")
			.and().withUser("hari").password(encoder.encode("2")).roles("cashier")
			.and().withUser("ashok").password(encoder.encode("3")).roles("admin");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in config"+e.getMessage());
		}
	}
	
	/*@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	@Override
	public void configure(WebSecurity web)
	{
		try {
			web.ignoring().antMatchers("/h2-console/**");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in bypass:"+e.getMessage());
		}
	}
}
