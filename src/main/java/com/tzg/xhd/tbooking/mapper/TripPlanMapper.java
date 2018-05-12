package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import com.tzg.xhd.tbooking.entity.TripPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripPlanMapper extends Mapper<TripPlan> {
    List<TripPlan> getTripPlanByName(@Param("name")String name);
}
