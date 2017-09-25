package com.jufan.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//@EnableEurekaClient
@EnableConfigServer
public class CloudConfigApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigApp.class, args);
	}
}
