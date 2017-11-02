package com.eztcn.organization.service;

import com.eztcn.api.bean.Hospital;

import java.util.List;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 10:38 2017/10/23
 */
public interface HospitalService {
    int saveOrUpdate(Hospital hospital);

    void deleteById(Integer id);

    Hospital findById(Integer id);

    List<Hospital> findByCondition(Hospital hospital);
}
