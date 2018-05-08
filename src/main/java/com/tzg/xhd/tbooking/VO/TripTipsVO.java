package com.tzg.xhd.tbooking.VO;

import com.tzg.xhd.tbooking.entity.TripTips;

import java.util.Map;

public class TripTipsVO extends TripTips{
    private Map<String,Object> map;

    private String[] timeOTW;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String[] getTimeOTW() {
        return timeOTW;
    }

    public void setTimeOTW(String[] timeOTW) {
        this.timeOTW = timeOTW;
    }
}
