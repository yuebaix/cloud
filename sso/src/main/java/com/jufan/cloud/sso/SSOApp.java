package com.jufan.cloud.sso;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients("com.jufan.cloud.facade")
@ComponentScan({"com.jufan.cloud.sso", "com.jufan.cloud.facade.fallback"})
public class SSOApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SSOApp.class).web(true).run(args);
    }
}
