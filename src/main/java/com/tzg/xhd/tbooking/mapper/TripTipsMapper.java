package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import com.tzg.xhd.tbooking.entity.TripTips;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripTipsMapper extends Mapper<TripTips> {
    List<TripTips> getTripTipsByName(@Param("name")String name);
}
