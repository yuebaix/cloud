package com.jufan.cloud.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients("com.jufan.cloud.facade")
@ComponentScan({"com.jufan.cloud.consumer", "com.jufan.cloud.facade.fallback"})
public class CloudConsumerApp {
//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudConsumerApp.class).web(true).run(args);
	}
}
