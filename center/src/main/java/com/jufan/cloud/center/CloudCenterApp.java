package com.jufan.cloud.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudCenterApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudCenterApp.class, args);
	}
}
