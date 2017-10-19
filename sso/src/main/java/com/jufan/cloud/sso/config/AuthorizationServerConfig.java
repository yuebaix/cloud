package com.jufan.cloud.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private RedisConnectionFactory connectionFactory;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DataSource dataSource;

//	@Bean
//	public TokenStore tokenStore() {//TODO 设置序列化策略
//		RedisTokenStore redisTokenStore = new RedisTokenStore(connectionFactory);
//		redisTokenStore.setPrefix("cloud:cloud_sso:");
//		return redisTokenStore;
//	}
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	@Bean
	public ApprovalStore approvalStore() {
		return new JdbcApprovalStore(dataSource);
	}
	@Bean
	public AuthorizationCodeServices authorizationCode() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}
	@Bean
	public ClientDetailsService clientDetails() {
		return new JdbcClientDetailsService(dataSource);
	}
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {//TODO 重新胜场jks替换
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(
				new ClassPathResource("keystore.jks"), "foobar".toCharArray())
				.getKeyPair("test");
		converter.setKeyPair(keyPair);
		return converter;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {//TODO 添加自定义clientDetailService
		endpoints
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)//若无，refresh_token会有UserDetailsService is required错误
				.tokenStore(tokenStore())
				.approvalStore(approvalStore())
				.accessTokenConverter(jwtAccessTokenConverter())
				.setClientDetailsService(clientDetails());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {//TODO 添加token验证代码
		security
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()");
	}
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//		oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')").checkTokenAccess(
//				"hasAuthority('ROLE_TRUSTED_CLIENT')");
//	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory()
//				.withClient("sso_client")
//					.scopes("xx")//此处的scopes是无用的，可以随意设置
//					.secret("sso_client_pwd")
//					.authorizedGrantTypes("password", "authorization_code", "refresh_token")
//					.and()
//				.withClient("gateway")
//					.scopes("xx")//此处的scopes是无用的，可以随意设置
//					.authorizedGrantTypes("implicit");
		clients.withClientDetails(clientDetails());
	}
}
