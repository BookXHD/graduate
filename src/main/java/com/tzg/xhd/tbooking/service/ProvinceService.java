package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    List<Province> getAllProvince();

    void save(Province province);
}
