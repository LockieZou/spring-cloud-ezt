package com.eztcn.user.service.impl;

import com.eztcn.api.bean.User;
import com.eztcn.user.dto.CustomUserDetails;
import com.eztcn.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 14:15 2017/10/30
 */
@Slf4j
@Component
public class UserAuthenticationServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(userName)) {
            throw new UsernameNotFoundException("用户名不能为空!");
        }

        /**
         * 下面是对用户名等其他内容的校验，这里测试只对ID校验
         */
        User user = userService.findById(Integer.parseInt(userName));

        if (user == null) {
            return null;
        }
        return new CustomUserDetails((long)user.getId(), user.getEuMobile(), user.getEuPassword());
    }
}
