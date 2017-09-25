package com.jufan.cloud.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConfigController {
	@Value("${whoisthis}")
	private String whoisthis;

	public String getWhoisthis() {
		return whoisthis;
	}

	public void setWhoisthis(String whoisthis) {
		this.whoisthis = whoisthis;
	}

	@RequestMapping("/whoisthis")
	public String showLuckyWord() {
		return "我是: " + getWhoisthis();
	}
}
