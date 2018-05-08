package com.tzg.xhd.tbooking.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:trip_plan表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-13
 */
@Table(name = "trip_plan")
public class TripPlan implements Serializable {
    /**
     * 旅游套餐表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 套餐名字（桐庐双人三日游）
     */
    private String name;

    /**
     * 套餐价格
     */
    private BigDecimal price;

    /**
     * 选择率 单位%
     */
    private Integer rate;

    /**
     * 旅行天数
     */
    private Integer days;

    /**
     * 图片
     */
    private String img;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 套餐景点（多个用逗号间隔）
     */
    private String spotIds;

    /**
     * 套餐描述
     */
    private String planDescribe;

    /**
     * 套餐日程
     */
    private String planRoute;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 本次旅游总人数
     */
    private Integer totalPerson;

    /**
     * 剩余名额
     */
    private Integer remainAssign;

    /**
     * trip_plan
     */
    private static final long serialVersionUID = 1L;

    /**
     * 旅游套餐表id
     * @return id 旅游套餐表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 旅游套餐表id
     * @param id 旅游套餐表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 套餐名字（桐庐双人三日游）
     * @return name 套餐名字（桐庐双人三日游）
     */
    public String getName() {
        return name;
    }

    /**
     * 套餐名字（桐庐双人三日游）
     * @param name 套餐名字（桐庐双人三日游）
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 套餐价格
     * @return price 套餐价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 套餐价格
     * @param price 套餐价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 图片
     * @return img 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 城市id
     * @return city_id 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 城市id
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 套餐景点（多个用逗号间隔）
     * @return spot_ids 套餐景点（多个用逗号间隔）
     */
    public String getSpotIds() {
        return spotIds;
    }

    /**
     * 套餐景点（多个用逗号间隔）
     * @param spotIds 套餐景点（多个用逗号间隔）
     */
    public void setSpotIds(String spotIds) {
        this.spotIds = spotIds == null ? null : spotIds.trim();
    }

    /**
     * 套餐描述
     * @return plan_describe 套餐描述
     */
    public String getPlanDescribe() {
        return planDescribe;
    }

    /**
     * 套餐描述
     * @param planDescribe 套餐描述
     */
    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe == null ? null : planDescribe.trim();
    }

    public String getPlanRoute() {
        return planRoute;
    }

    public void setPlanRoute(String planRoute) {
        this.planRoute = planRoute;
    }

    /**
     * 开始日期
     * @return start_date 开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 开始日期
     * @param startDate 开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 结束日期
     * @return end_date 结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 结束日期
     * @param endDate 结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 本次旅游总人数
     * @return total_person 本次旅游总人数
     */
    public Integer getTotalPerson() {
        return totalPerson;
    }

    /**
     * 本次旅游总人数
     * @param totalPerson 本次旅游总人数
     */
    public void setTotalPerson(Integer totalPerson) {
        this.totalPerson = totalPerson;
    }

    /**
     * 剩余名额
     * @return remain_assign 剩余名额
     */
    public Integer getRemainAssign() {
        return remainAssign;
    }

    /**
     * 剩余名额
     * @param remainAssign 剩余名额
     */
    public void setRemainAssign(Integer remainAssign) {
        this.remainAssign = remainAssign;
    }
}