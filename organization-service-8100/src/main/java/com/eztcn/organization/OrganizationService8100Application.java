package com.eztcn.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.eztcn.organization.mapper")
@EnableFeignClients
public class OrganizationService8100Application {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationService8100Application.class, args);
	}
}
