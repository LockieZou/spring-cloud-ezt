package com.eztcn.user.service.impl;

import com.eztcn.api.bean.User;
import com.eztcn.user.mapper.UserMapper;
import com.eztcn.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 9:43 2017/10/24
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int saveOrUpdate(User user) {
        return 0;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
