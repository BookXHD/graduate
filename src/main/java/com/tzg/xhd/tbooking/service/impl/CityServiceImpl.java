package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.City;
import com.tzg.xhd.tbooking.service.CityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("cityService")
@Transactional
public class CityServiceImpl extends AbstractService<City> implements CityService {
}
