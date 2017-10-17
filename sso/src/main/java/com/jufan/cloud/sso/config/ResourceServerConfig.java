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
//				.csrf()
//				.csrfTokenRepository(csrfTokenRepository())
//				.and()
//				.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				.authorizeRequests().antMatchers("/", "/home", "/oauth/token", "/oauth/authorize").permitAll()
				.anyRequest().authenticated()
				.and()
//				.formLogin()
//				.loginPage("/login")
//				.failureForwardUrl("/login?error")
//				.permitAll()
//				.and()
//				.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/login?logout")
//				.permitAll()
//				.and()
				.httpBasic();
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

//	private CsrfTokenRepository csrfTokenRepository() {
//		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		repository.setHeaderName("X-XSRF-TOKEN");
//		return repository;
//	}
}
