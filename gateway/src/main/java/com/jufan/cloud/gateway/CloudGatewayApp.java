package com.jufan.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CloudGatewayApp {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApp.class, args);
	}
}
