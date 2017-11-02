package com.eztcn.user.mapper;

import com.eztcn.api.bean.User;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 18:28 2017/10/23
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
