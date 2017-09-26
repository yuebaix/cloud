package com.jufan.cloud.facade.fallback;

import com.jufan.cloud.facade.DemoService;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceHystrix implements DemoService {
	@Override
	public String show(String appName) {
		return "error";
	}
}
