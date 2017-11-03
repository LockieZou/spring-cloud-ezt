package com.eztcn.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zouxiliang
 */
@SpringBootApplication
@EnableAdminServer
public class SpringCloudAdmin8081Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAdmin8081Application.class, args);
	}
}
