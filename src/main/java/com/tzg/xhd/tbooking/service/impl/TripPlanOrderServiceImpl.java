package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.TripPlan;
import com.tzg.xhd.tbooking.entity.TripPlanOrder;
import com.tzg.xhd.tbooking.mapper.TripPlanOrderMapper;
import com.tzg.xhd.tbooking.service.TripPlanOrderService;
import com.tzg.xhd.tbooking.service.TripPlanService;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("tripPlanOrderService")
@Transactional
public class TripPlanOrderServiceImpl extends AbstractService<TripPlanOrder> implements TripPlanOrderService {
    @Autowired
    private TripPlanOrderMapper tripPlanOrderMapper;

    @Autowired
    private TripPlanService tripPlanService;

    @Override
    public void CreateOrderByCollect(String planId) {
        TripPlanOrder tripPlanOrder = new TripPlanOrder();
        tripPlanOrder.setTripPlanId(Integer.parseInt(planId));
        tripPlanOrder.setUserId(HttpSessionUtil.getLoginUserSession().getId());
        tripPlanOrder.setPayState(1);
        TripPlan tripPlan = tripPlanService.findById(tripPlanOrder.getTripPlanId());
        tripPlanOrder.setTripPlanName(tripPlan.getName());
        save(tripPlanOrder);
    }

    @Override
    public void SetBuyFromCollect(String planOrderId, String out_trade_no) {
        TripPlanOrder tripPlanOrder = findById(Integer.parseInt(planOrderId));
        tripPlanOrder.setPayState(2);
        tripPlanOrder.setOrderTime(new Date());
        tripPlanOrder.setOrderNo(out_trade_no);
        update(tripPlanOrder);
        TripPlan tripPlan = tripPlanService.findById(tripPlanOrder.getTripPlanId());
        tripPlan.setRemainAssign(tripPlan.getRemainAssign()-1);
        tripPlanService.update(tripPlan);
    }

    @Override
    public void CreateOrderByBought(String planId, String out_trade_no) {
        TripPlanOrder tripPlanOrder = new TripPlanOrder();
        tripPlanOrder.setTripPlanId(Integer.parseInt(planId));
        tripPlanOrder.setUserId(HttpSessionUtil.getLoginUserSession().getId());
        tripPlanOrder.setPayState(2);
        tripPlanOrder.setOrderTime(new Date());
        tripPlanOrder.setOrderNo(out_trade_no);
        TripPlan tripPlan = tripPlanService.findById(tripPlanOrder.getTripPlanId());
        tripPlanOrder.setTripPlanName(tripPlan.getName());
        save(tripPlanOrder);
        tripPlan.setRemainAssign(tripPlan.getRemainAssign()-1);
        tripPlanService.update(tripPlan);
    }

    @Override
    public List<TripPlanOrder> selectByUser(Integer userId){
        TripPlanOrder tripPlanOrder = new TripPlanOrder();
        tripPlanOrder.setUserId(userId);
        return findByModel(tripPlanOrder);
    }
}
