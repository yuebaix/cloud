package com.jufan.cloud.consumer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients("com.jufan.cloud.facade")
@ComponentScan({"com.jufan.cloud.consumer", "com.jufan.cloud.facade.fallback"})
public class CloudConsumerApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudConsumerApp.class).web(true).run(args);
	}
}
