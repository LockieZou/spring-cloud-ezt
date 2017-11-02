package com.eztcn;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 15:39 2017/10/31
 */
@Data
@Component
@EnableAutoConfiguration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "documentation.swagger")
public class SwaggerServiceConfig {
    List<SwaggerServices> swagger;

    public List<SwaggerServices> getServices() {
        return swagger;
    }

    public void setServices(List<SwaggerServices> swaggerServices) {
        this.swagger = swaggerServices;
    }
    @Data
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "documentation.swagger.services")
    public static class SwaggerServices {
        private String name;
        private String url;
        private String version;
    }
}
