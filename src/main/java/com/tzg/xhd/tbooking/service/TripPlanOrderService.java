package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.TripPlanOrder;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripPlanOrderService extends BaseService<TripPlanOrder> {
    /**
     * 收藏旅游套餐生成订单记录
     * @param planId
     */
    void CreateOrderByCollect(String planId);

    /**
     * 订单记录：收藏->已支付
     * @param planOrderId
     */
    void SetBuyFromCollect(String planOrderId, String out_trade_no);

    /**
     * 直接购买旅游套餐生成订单记录
     * @param planId
     */
    void CreateOrderByBought(String planId, String out_trade_no);

    /**
     * 根据用户Id获得该用户的所有订单记录
     * @param userId
     * @return
     */
    List<TripPlanOrder> selectByUser(Integer userId);
}
