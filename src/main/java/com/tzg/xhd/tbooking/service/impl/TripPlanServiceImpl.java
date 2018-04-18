package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.TripPlan;
import com.tzg.xhd.tbooking.mapper.TripPlanMapper;
import com.tzg.xhd.tbooking.service.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("tripPlanService")
@Transactional
public class TripPlanServiceImpl extends AbstractService<TripPlan> implements TripPlanService {
    @Autowired
    private TripPlanMapper tripPlanMapper;
}
