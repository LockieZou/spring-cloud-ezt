package com.eztcn.organization.controller;

import com.eztcn.api.bean.Hospital;
import com.eztcn.api.bean.User;
import com.eztcn.organization.config.OrganizationProperties;
import com.eztcn.organization.service.HospitalService;
import com.eztcn.organization.service.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: zouxiliang
 * @Description:
 * @Date: Created in 10:41 2017/10/23
 */
@Api(description = "所属机构",tags = "HospitalController",basePath = "/hospital")
@RestController
@RequestMapping("/organization")
@EnableConfigurationProperties(OrganizationProperties.class)
public class HospitalController {
    @Resource
    HospitalService hospitalService;

    @Resource
    UserClient userClient;

    //自定义config参数
    @Autowired
    OrganizationProperties organizationProperties;

    @ApiOperation(value = "测试页面")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "Hello !";
    }

    @ApiOperation(value = "获取医院名称", notes = "")
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
        Hospital hospital = hospitalService.findById(2);
        return hospital.getName();
    }

    @ApiOperation(value = "获取用户名", notes = "")
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getUserName() {
        return userClient.getUserName();
    }

    //获取用户名
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(@RequestParam Integer id){
        return userClient.getUserById(id);
    }

    @RequestMapping(value = "/getConfig", method = RequestMethod.GET)
    public String getConfig() {
        StringBuffer sb = new StringBuffer();
        String company  = organizationProperties.getCompany();
        sb.append(company+"<br/>");

        List<Map<String, String>> provinceList = organizationProperties.getProvinceList();
        for (Map<String, String> provinceMap : provinceList) {
            sb.append("省份："+provinceMap.get("name")+"，城市："+provinceMap.get("value") + "<br/>");
        }

        List<String> cityList = organizationProperties.getCityList();
        for (String city : cityList) {
            sb.append(city + "<br/>");
        }

        Map<String, String> map = organizationProperties.getMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()+":"+entry.getValue()+"<br/>");
        }

        return sb.toString();
    }
}
