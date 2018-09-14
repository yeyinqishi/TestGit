package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@RequestMapping("/")
	String index() {
		String r_value = "Hello Spring Boot";
		stringRedisTemplate.opsForValue().set("test1","测试abc");
		Object object1 =  stringRedisTemplate.opsForValue().get("test");
		Object object2 =  stringRedisTemplate.opsForValue().get("test1");
		r_value = String.valueOf(object1);
		String r_value1 = String.valueOf(object2);
		return r_value;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
