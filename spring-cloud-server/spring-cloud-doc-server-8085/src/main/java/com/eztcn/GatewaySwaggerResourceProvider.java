package com.eztcn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 11:47 2017/10/31
 */
@Slf4j
@Component
@Primary
@EnableAutoConfiguration
public class GatewaySwaggerResourceProvider implements SwaggerResourcesProvider {
    @Autowired
    SwaggerServiceConfig swaggerServiceConfig;

    public GatewaySwaggerResourceProvider() {
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resourceList = new ArrayList<>();

        swaggerServiceConfig.getServices().forEach(service -> {
            resourceList.add(swaggerResource(service.getName(),service.getUrl(),service.getVersion()));
        });
        return resourceList;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
