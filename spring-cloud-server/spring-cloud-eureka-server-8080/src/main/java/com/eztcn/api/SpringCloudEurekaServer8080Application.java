package com.eztcn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer8080Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServer8080Application.class, args);
	}
}
