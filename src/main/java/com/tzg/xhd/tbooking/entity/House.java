package com.tzg.xhd.tbooking.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:house表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-20
 */
@Table(name = "house")
public class House implements Serializable {
    /**
     * 用户住宿记录表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 唯一流水号
     */
    private String orderNo;

    /**
     * 房客id
     */
    private Integer userId;

    /**
     * 旅馆id
     */
    private Integer houseId;

    /**
     * 预订入住时间
     */
    private Date roomTime;

    /**
     * 住宿时间（天数）
     */
    private Integer roomDays;

    /**
     * 预订房间数
     */
    private Integer roomAmount;

    /**
     * 住宿押金
     */
    private Integer readyPay;

    /**
     * 住宿总价
     */
    private Integer lastPay;

    /**
     * 订单产生时间
     */
    private Date createTime;

    /**
     * house
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户住宿记录表id
     * @return id 用户住宿记录表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户住宿记录表id
     * @param id 用户住宿记录表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 房客id
     * @return user_id 房客id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 房客id
     * @param userId 房客id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 旅馆id
     * @return house_id 旅馆id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 旅馆id
     * @param houseId 旅馆id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * 预订入住时间
     * @return room_time 预订入住时间
     */
    public Date getRoomTime() {
        return roomTime;
    }

    /**
     * 预订入住时间
     * @param roomTime 预订入住时间
     */
    public void setRoomTime(Date roomTime) {
        this.roomTime = roomTime;
    }

    /**
     * 住宿时间（天数）
     * @return room_days 住宿时间（天数）
     */
    public Integer getRoomDays() {
        return roomDays;
    }

    /**
     * 住宿时间（天数）
     * @param roomDays 住宿时间（天数）
     */
    public void setRoomDays(Integer roomDays) {
        this.roomDays = roomDays;
    }

    /**
     * 预订房间数
     * @return room_amount 预订房间数
     */
    public Integer getRoomAmount() {
        return roomAmount;
    }

    /**
     * 预订房间数
     * @param roomAmount 预订房间数
     */
    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    /**
     * 住宿押金
     * @return ready_pay 住宿押金
     */
    public Integer getReadyPay() {
        return readyPay;
    }

    /**
     * 住宿押金
     * @param readyPay 住宿押金
     */
    public void setReadyPay(Integer readyPay) {
        this.readyPay = readyPay;
    }

    /**
     * 住宿总价
     * @return last_pay 住宿总价
     */
    public Integer getLastPay() {
        return lastPay;
    }

    /**
     * 住宿总价
     * @param lastPay 住宿总价
     */
    public void setLastPay(Integer lastPay) {
        this.lastPay = lastPay;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
}