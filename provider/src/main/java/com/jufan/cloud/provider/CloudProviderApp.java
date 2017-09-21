package com.jufan.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(CloudProviderApp.class, args);
	}
}