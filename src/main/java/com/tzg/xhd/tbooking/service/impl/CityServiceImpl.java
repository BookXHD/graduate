package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.City;
import com.tzg.xhd.tbooking.mapper.CityMapper;
import com.tzg.xhd.tbooking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("cityService")
@Transactional
public class CityServiceImpl extends AbstractService<City> implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public List<City> getCityByProvince(String province){
        return cityMapper.getCityByProvince(province);
    }

    @Override
    public List<City> getCityByName(String cityName) {
        return cityMapper.getCityByName(cityName);
    }
}
