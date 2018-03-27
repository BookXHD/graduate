package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import org.springframework.stereotype.Repository;
import com.tzg.xhd.tbooking.entity.City;

import java.util.List;

@Repository
public interface CityMapper extends Mapper<City>{

    List<City> getCityByProvince(String province);
}
