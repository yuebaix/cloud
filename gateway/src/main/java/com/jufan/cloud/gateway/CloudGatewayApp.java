package com.jufan.cloud.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class CloudGatewayApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudGatewayApp.class).web(true).run(args);
	}
}