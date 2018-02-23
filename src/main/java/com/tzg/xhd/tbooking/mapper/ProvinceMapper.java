package com.tzg.xhd.tbooking.mapper;

import org.springframework.stereotype.Repository;
import com.tzg.xhd.tbooking.entity.Province;

import java.util.List;

@Repository
public interface ProvinceMapper {
    List<Province> getAllProvince();

    void save(Province province);
}
