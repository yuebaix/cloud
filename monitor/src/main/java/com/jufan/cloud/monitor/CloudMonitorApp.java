package com.jufan.cloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringCloudApplication
@EnableTurbine
@EnableHystrixDashboard
public class CloudMonitorApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudMonitorApp.class, args);
    }
}
