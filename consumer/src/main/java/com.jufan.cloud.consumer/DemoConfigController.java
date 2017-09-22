package com.jufan.cloud.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

public class DemoConfigController {
	@Value("${whoisthis}") String whoisthis;

	@RequestMapping("/whoisthis")
	public String showLuckyWord() {
		return "我是: " + whoisthis;
	}
}
