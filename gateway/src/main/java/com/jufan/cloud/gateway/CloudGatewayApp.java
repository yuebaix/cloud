package com.jufan.cloud.gateway;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringCloudApplication
@EnableZuulProxy
public class CloudGatewayApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudGatewayApp.class).web(true).run(args);
	}
	@Component
	@EnableOAuth2Sso // 实现基于OAuth2的单点登录，建议跟踪进代码阅读以下该注解的注释，很有用
	public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.
					antMatcher("/**")
					// 所有请求都得经过认证和授权
					.authorizeRequests().anyRequest().authenticated()
					.and().authorizeRequests().antMatchers("/","/anon").permitAll()
					.and()
					// 这里之所以要禁用csrf，是为了方便。
					// 否则，退出链接必须要发送一个post请求，请求还得带csrf token
					// 那样我还得写一个界面，发送post请求
					.csrf().disable()
					// 退出的URL是/logout
					.logout().logoutUrl("/logout").permitAll()
					// 退出成功后，跳转到/路径。
					.logoutSuccessUrl("/login");
		}
	}
}