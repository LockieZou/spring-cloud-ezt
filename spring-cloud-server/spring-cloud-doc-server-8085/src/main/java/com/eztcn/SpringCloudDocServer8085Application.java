package com.eztcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Component
@EnableAutoConfiguration
@EnableSwagger2
@EnableDiscoveryClient
public class SpringCloudDocServer8085Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDocServer8085Application.class, args);
	}
}
