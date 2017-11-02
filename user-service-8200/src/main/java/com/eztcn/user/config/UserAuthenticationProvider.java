package com.eztcn.user.config;

import com.eztcn.user.dto.CustomUserDetails;
import com.eztcn.user.service.impl.UserAuthenticationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 14:13 2017/10/30
 */
@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserAuthenticationServiceImpl userAuth;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("用户名：{}",authentication.getName());
        log.info("密码：{}",authentication.getCredentials());

        /**
         * 测试输入的用户ID是否正确
         */
        CustomUserDetails userDetail = userAuth.loadUserByUsername(authentication.getName());
        try {
            if(userDetail != null && userDetail.getUserid() != null) {
                //如果验证通过，将返回一个对象
                return new UsernamePasswordAuthenticationToken(userDetail,
                        authentication.getCredentials(), userDetail.getAuthorities());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw e;
        }

        //验证不通过，返回null
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
