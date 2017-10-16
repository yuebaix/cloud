package com.jufan.cloud.sso;

import org.junit.Test;

import java.util.UUID;

public class UUIDTest {
	@Test
	public void generateUuid() {
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID().toString().length());
	}
}
