package com.jufan.cloud.facade;

import com.jufan.cloud.facade.fallback.DemoServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "b-demo-provider", fallback = DemoServiceHystrix.class)
public interface DemoService {
	@RequestMapping("/service-instances/{applicationName}")
	public String show(@RequestParam("applicationName") String appName);
}
