package com.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("sai")
		    .password("{noop}Sai@123")
		    .authorities("USER");

		auth.inMemoryAuthentication()
		    .withUser("ratan")
		    .password("{noop}Ratan@123")
		    .authorities("ADMIN");
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/principal").hasAuthority("ADMIN")
			.antMatchers("/teacher").hasAuthority("USER")
			.and()
			.formLogin()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
}

//"SecureLearnHub" Project conveys the idea of a secure platform for learning and education,
//which aligns with the focus on security and the different user roles (ADMIN and USER) in your application.
