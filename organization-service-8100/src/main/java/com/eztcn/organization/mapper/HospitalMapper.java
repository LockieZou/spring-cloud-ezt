package com.eztcn.organization.mapper;

import com.eztcn.api.bean.Hospital;

import java.util.List;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 10:34 2017/10/23
 */
public interface HospitalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);

    List<Hospital> findByCondition(Hospital hospital);
}
