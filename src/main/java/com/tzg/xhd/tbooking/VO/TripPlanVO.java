package com.tzg.xhd.tbooking.VO;

import com.tzg.xhd.tbooking.entity.TripPlan;

import java.util.Map;

public class TripPlanVO extends TripPlan {
    private Integer viewCount;

    private Map<String,Object> daysPlan;

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Map<String, Object> getDaysPlan() {
        return daysPlan;
    }

    public void setDaysPlan(Map<String, Object> daysPlan) {
        this.daysPlan = daysPlan;
    }
}
