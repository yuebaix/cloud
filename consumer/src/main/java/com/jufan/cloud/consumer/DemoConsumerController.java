package com.jufan.cloud.consumer;

import com.jufan.cloud.facade.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {
	@Autowired
	DemoService demoService;

	@RequestMapping("/")
	public String sayhello() {
		return "demo-consumer";
	}

	@RequestMapping("/show")
	public String show() {
		System.err.println("err");

		return demoService.show("demo-consumer");
	}

	@RequestMapping("/show/{appName}")
	public String showByName(@PathVariable String appName) {
		return demoService.show(appName);
	}
}
