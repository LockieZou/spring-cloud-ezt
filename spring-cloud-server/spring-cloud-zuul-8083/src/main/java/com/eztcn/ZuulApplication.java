package com.eztcn;

import com.eztcn.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 17:19 2017/10/25
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
