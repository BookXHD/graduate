package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.entity.Province;
import com.tzg.xhd.tbooking.service.ProvinceService;
import com.tzg.xhd.tbooking.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("provinceService")
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceMapper ProvinceMapper;

    @Override
    public List<Province> getAllProvince() {
        return ProvinceMapper.getAllProvince();
    }

    @Override
    public void save(Province province){
        ProvinceMapper.save(province);
    }
}
