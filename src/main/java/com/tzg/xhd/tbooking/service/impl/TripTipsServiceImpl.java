package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.VO.TripTipsVO;
import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.TripTips;
import com.tzg.xhd.tbooking.mapper.TripTipsMapper;
import com.tzg.xhd.tbooking.service.TripTipsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("tripTipsService")
@Slf4j
@Transactional
public class TripTipsServiceImpl extends AbstractService<TripTips> implements TripTipsService {
    @Autowired
    private TripTipsMapper tripTipsMapper;

    @Override
    public List<TripTipsVO> getTripTipsList(Integer cityId, Integer days) {
        List<TripTipsVO> tripTipsVOS = new ArrayList<>();
        try{
            TripTips tripTips = new TripTips();
            tripTips.setCityId(cityId);
            List<TripTips> tripTipsList = tripTipsMapper.select(tripTips);
            for(TripTips tripTips1 : tripTipsList) {
                if(days.intValue()==0){
                    break;
                }
                Map<String,Object> daysPlanMap = new HashMap<>();
                TripTipsVO tripTipsVO = new TripTipsVO();
                BeanUtils.copyProperties(tripTips1, tripTipsVO);
                //获取路线Map
                String day = tripTips1.getRoute();
                if(!StringUtils.isBlank(day)) {
                    String[] plan = day.split(":");
                    String time = plan[0];
                    String spots = plan[1];
                    String[] spot = spots.split(",");
                    List<String> list = Arrays.asList(spot);
                    daysPlanMap.put(time, list);
                    tripTipsVO.setMap(daysPlanMap);
                }
                //获取景点间隔的路程时间
                String spitTime = tripTips1.getSpitTime();
                if(!StringUtils.isBlank(spitTime)) {
                    tripTipsVO.setTimeOTW(spitTime.split(","));
                }
                tripTipsVOS.add(tripTipsVO);
                days--;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return tripTipsVOS;
    }

    @Override
    public List<TripTips> getTripTipsByName(String tripTipsName) {
        return tripTipsMapper.getTripTipsByName(tripTipsName);
    }
}
