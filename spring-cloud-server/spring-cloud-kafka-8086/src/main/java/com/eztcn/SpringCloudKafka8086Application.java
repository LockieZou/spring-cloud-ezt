package com.eztcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@RemoteApplicationEventScan(basePackages = "com.eztcn.event")
public class SpringCloudKafka8086Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKafka8086Application.class, args);
	}
}
