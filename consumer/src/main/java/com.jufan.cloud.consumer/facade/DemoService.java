package com.jufan.cloud.consumer.facade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-provider")
public interface DemoService {
	@RequestMapping("/service-instances/{applicationName}")
	public String show();
}
