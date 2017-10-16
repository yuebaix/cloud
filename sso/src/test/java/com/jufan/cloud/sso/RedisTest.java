package com.jufan.cloud.sso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
 		redisTemplate.opsForValue().set("obj", 1);
		stringRedisTemplate.opsForValue().set("str", "1");
		System.out.println(redisTemplate.opsForValue().get("obj"));
		System.out.println(stringRedisTemplate.opsForValue().get("str"));
	}

}