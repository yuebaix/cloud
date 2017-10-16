package com.jufan.cloud.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
//		http
//				.authorizeRequests()
//					.antMatchers("/login","/oauth/token").permitAll()
//					.anyRequest().authenticated()
//					.and()
//				.csrf().disable()
//					.formLogin().loginPage("/login").permitAll()
//					.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();
	}
}
