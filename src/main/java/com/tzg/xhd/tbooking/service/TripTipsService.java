package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.VO.TripTipsVO;
import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.TripTips;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripTipsService extends BaseService<TripTips> {
    List<TripTipsVO> getTripTipsList(Integer cityId, Integer days);

    List<TripTips> getTripTipsByName(String tripTipsName);
}
