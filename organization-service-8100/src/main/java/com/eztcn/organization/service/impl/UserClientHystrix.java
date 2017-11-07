package com.eztcn.organization.service.impl;

import com.eztcn.api.bean.User;
import com.eztcn.organization.service.UserClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zouxiliang
 * @Description:
 * @Date: Created in 17:08 2017/10/24
 */
@Component
public class UserClientHystrix implements UserClient {
    @Override
    public String getUserName() {
        return "sorry,there is something wrong!";
    }

    @Override
    public User getUserById(@RequestParam Integer id) {
        return null;
    }
}
