package com.eztcn.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.eztcn.user.mapper")
public class UserService8200Application {

	public static void main(String[] args) {
		SpringApplication.run(UserService8200Application.class, args);
	}
}
