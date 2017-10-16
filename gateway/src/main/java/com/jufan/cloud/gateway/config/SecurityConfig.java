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
//		http
//				// 所有请求都得经过认证和授权
//				.antMatcher("/**").authorizeRequests().anyRequest().authenticated()
//				.and().authorizeRequests().antMatchers("/","/sso/login","/sso/oauth/token", "/oauth/authorize").permitAll()
//				// 这里之所以要禁用csrf，是为了方便。
//				// 否则，退出链接必须要发送一个post请求，请求还得带csrf token
//				// 那样还得写一个界面，发送post请求
//				.and().csrf().disable()
//				// 退出的URL是/logout,退出后跳转到/login
//				.logout().logoutUrl("/sso/logout").permitAll().logoutSuccessUrl("/sso/login");

		http
				.csrf().disable();

//		http
//				.authorizeRequests()
//					.antMatchers("/").permitAll()
//					.anyRequest().authenticated()
//					.and()
//				.csrf().disable()
//					.formLogin().loginPage("/sso/login").permitAll()
//					.and().logout().logoutUrl("/sso/logout").logoutSuccessUrl("/sso/login").permitAll();
	}
}
