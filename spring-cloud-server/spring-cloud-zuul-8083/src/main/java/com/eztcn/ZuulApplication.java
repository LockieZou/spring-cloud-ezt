package com.eztcn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 17:19 2017/10/25
 */
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

//    @Bean
//    public AccessFilter accessFilter() {
//        return new AccessFilter();
//    }
}
