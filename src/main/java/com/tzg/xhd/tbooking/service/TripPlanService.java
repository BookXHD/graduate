package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.VO.TripPlanVO;
import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.TripPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripPlanService extends BaseService<TripPlan> {
    /**
     * 以tripPlan实体类内的fields为参数 查找得到TripPlanVO列表
     * @param tripPlan
     * @return List<TripPlanVO>
     */
    List<TripPlanVO> getTripPlanVOList(TripPlan tripPlan);

    /**
     * getTripPlanByName
     * @param name
     * @return
     */
    List<TripPlan> getTripPlanByName(String name);
}
