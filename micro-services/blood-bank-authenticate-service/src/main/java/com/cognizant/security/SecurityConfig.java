package com.cognizant.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public static Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(inMemoryDetailsManger());
		LOGGER.info("Configure auth Start");
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		LOGGER.info("Configure auth End");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and()
			.authorizeRequests()
			.antMatchers("/authenticate").permitAll()
				.antMatchers("/users").anonymous()
				.antMatchers("/users/**").permitAll()
				.antMatchers("/states").permitAll()
				.antMatchers("/cities/**").permitAll()
				.antMatchers("/areas/**").permitAll()
				.antMatchers("/bloodGroups").permitAll()
				.antMatchers("/requestPostingDetails").permitAll()
				.antMatchers("/feedback").permitAll()
				.antMatchers("/faqs/**").permitAll()
				.anyRequest().authenticated()
				.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

}
