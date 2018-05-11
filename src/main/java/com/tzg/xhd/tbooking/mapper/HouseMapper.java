package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import com.tzg.xhd.tbooking.entity.House;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseMapper extends Mapper<House> {
    List<House> selectOrder(Map<String, Object> map);
}
