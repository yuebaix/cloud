package com.jufan.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DemoGatewayController {
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
