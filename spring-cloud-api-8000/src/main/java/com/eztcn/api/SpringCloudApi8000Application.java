package com.eztcn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudApi8000Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApi8000Application.class, args);
	}
}
