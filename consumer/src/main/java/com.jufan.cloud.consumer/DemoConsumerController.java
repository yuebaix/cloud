package com.jufan.cloud.consumer;

import com.jufan.cloud.consumer.facade.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {
	@Autowired
	DemoService demoService;

	@RequestMapping("/show")
	public String show() {
		return demoService.show();
	}
}
