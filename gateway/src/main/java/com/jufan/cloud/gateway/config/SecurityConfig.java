package com.jufan.cloud.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				// 所有请求都得经过认证和授权
				.antMatcher("/**").authorizeRequests()
				.antMatchers("/sso/oauth/token", "/sso/oauth/authorize").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.csrf().disable();
	}
}
