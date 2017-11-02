package com.eztcn.organization.service;

import com.eztcn.api.bean.User;
import com.eztcn.organization.service.impl.UserClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 10:47 2017/10/24
 */
@FeignClient(name = "user-service-8200",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping(value = "/user/getUserName", method = RequestMethod.GET)
    String getUserName();

    @RequestMapping(value = "/user/getUserById", method = RequestMethod.GET)
    User getUserById(@RequestParam(value = "id") Integer id);
}
