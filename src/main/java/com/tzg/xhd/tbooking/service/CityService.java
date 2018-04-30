package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.entity.City;
import org.springframework.stereotype.Service;
import com.tzg.xhd.tbooking.common.BaseService;

import java.util.List;

@Service
public interface CityService extends BaseService<City> {

    /**
     * 根据 省份id 取出该省所有城市
     * @param province
     * @return
     */
    List<City> getCityByProvince(String province);
}
