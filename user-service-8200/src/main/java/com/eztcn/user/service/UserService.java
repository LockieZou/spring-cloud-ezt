package com.eztcn.user.service;

import com.eztcn.api.bean.User;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 18:27 2017/10/23
 */
public interface UserService {
    int saveOrUpdate(User user);

    User findById(Integer id);

}
