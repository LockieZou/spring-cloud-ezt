package com.eztcn.organization.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zouxiliang
 * @Description:
 * @Date: Created in 18:20 2017/10/24
 */
@Data
@ConfigurationProperties(prefix = "organization")
//@Component
public class OrganizationProperties {
    private String company;
    private String[] ids;
    private List<Map<String,String>> provinceList = new ArrayList<>();
    private List<String> cityList = new ArrayList<>();
    private Map<String,String> map = new HashMap<>();
}
