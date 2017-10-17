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
				.csrf().disable();
//				.and().csrf()
//				.csrfTokenRepository(csrfTokenRepository())
//				.and()
//				.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
//				.logout().logoutUrl("/sso/logout").permitAll()
//				.logoutSuccessUrl("/");
	}

//	private Filter csrfHeaderFilter() {
//		return new OncePerRequestFilter() {
//			@Override
//			protected void doFilterInternal(HttpServletRequest request,
//			                                HttpServletResponse response, FilterChain filterChain)
//					throws ServletException, IOException {
//				CsrfToken csrf = (CsrfToken) request
//						.getAttribute(CsrfToken.class.getName());
//				if (csrf != null) {
//					Cookie cookie = new Cookie("XSRF-TOKEN",
//							csrf.getToken());
//					cookie.setPath("/");
//					response.addCookie(cookie);
//				}
//				filterChain.doFilter(request, response);
//			}
//		};
//	}
//
//	private CsrfTokenRepository csrfTokenRepository() {
//		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		repository.setHeaderName("X-XSRF-TOKEN");
//		return repository;
//	}
}
