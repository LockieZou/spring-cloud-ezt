package com.eztcn.organization.service.impl;

import com.eztcn.api.bean.Hospital;
import com.eztcn.organization.mapper.HospitalMapper;
import com.eztcn.organization.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zouxiliang
 * @Description:
 * @Date: Created in 10:39 2017/10/23
 */
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Resource
    HospitalMapper hospitalMapper;

    @Override
    public int saveOrUpdate(Hospital hospital) {
        if(hospital != null && hospital.getId() == null) {
            //新增
            return hospitalMapper.insert(hospital);
        } else {
            //更新
            return hospitalMapper.updateByPrimaryKey(hospital);
        }
    }

    @Override
    public void deleteById(Integer id) {
        hospitalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Hospital findById(Integer id) {
        return hospitalMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Hospital> findByCondition(Hospital hospital) {
        return hospitalMapper.findByCondition(hospital);
    }
}
