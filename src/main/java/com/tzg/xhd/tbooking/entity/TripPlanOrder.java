package com.tzg.xhd.tbooking.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:trip_plan_order表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-14
 */
@Table(name = "trip_plan_order")
public class TripPlanOrder implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订套餐的用户id
     */
    private Integer userId;

    /**
     * 订的旅游套餐id
     */
    private Integer tripPlanId;

    /**
     * 订的套餐名字
     */
    private String tripPlanName;

    /**
     * 下订单的时间
     */
    private Date orderTime;

    /**
     * 旅游人数
     */
    private Integer personAmount;

    /**
     * 支付总额
     */
    private BigDecimal payAmount;

    /**
     * 状态：1.收藏；2.已支付；3.已完成；
     */
    private Integer payState;


    /**
     * trip_plan_order
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 订单号
     * @return orderNo 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 订套餐的用户id
     * @return user_id 订套餐的用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 订套餐的用户id
     * @param userId 订套餐的用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 订的旅游套餐id
     * @return trip_plan_id 订的旅游套餐id
     */
    public Integer getTripPlanId() {
        return tripPlanId;
    }

    /**
     * 订的旅游套餐id
     * @param tripPlanId 订的旅游套餐id
     */
    public void setTripPlanId(Integer tripPlanId) {
        this.tripPlanId = tripPlanId;
    }

    public String getTripPlanName() {
        return tripPlanName;
    }

    public void setTripPlanName(String tripPlanName) {
        this.tripPlanName = tripPlanName;
    }

    /**
     * 下订单的时间
     * @return order_time 下订单的时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 下订单的时间
     * @param orderTime 下订单的时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 旅游人数
     * @return person_amount 旅游人数
     */
    public Integer getPersonAmount() {
        return personAmount;
    }

    /**
     * 旅游人数
     * @param personAmount 旅游人数
     */
    public void setPersonAmount(Integer personAmount) {
        this.personAmount = personAmount;
    }

    /**
     * 支付总额
     * @return pay_amount 支付总额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 支付总额
     * @param payAmount 支付总额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 状态：1--收藏；2.已支付；
     * @return pay_state 状态：1--收藏；2.已支付；
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 状态：1--收藏；2.已支付；
     * @param payState 状态：1--收藏；2.已支付；
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }
}