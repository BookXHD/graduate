package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.VO.TripPlanVO;
import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.TripPlan;
import com.tzg.xhd.tbooking.mapper.TripPlanMapper;
import com.tzg.xhd.tbooking.service.TripPlanService;
import com.tzg.xhd.tbooking.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("tripPlanService")
@Slf4j
@Transactional
public class TripPlanServiceImpl extends AbstractService<TripPlan> implements TripPlanService {
    @Autowired
    private TripPlanMapper tripPlanMapper;

    @Override
    public List<TripPlanVO> getTripPlanVOList(TripPlan tripPlan) {
        List<TripPlan> tripPlans = findByModel(tripPlan);
        List<TripPlanVO> tripPlanVOList = new ArrayList<>();
        try{
            for(TripPlan tripPlan1 : tripPlans){
                TripPlanVO tripPlanVO = new TripPlanVO();
                BeanUtils.copyProperties(tripPlan1,tripPlanVO);
                String viewCount = RedisUtil.getKey("tripPlan"+tripPlan1.getId());
                if(StringUtils.isBlank(viewCount)){
                    viewCount = "0";
                }
                tripPlanVO.setViewCount(new Integer(viewCount));
                tripPlanVOList.add(tripPlanVO);
            }
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return tripPlanVOList;
    }

}
