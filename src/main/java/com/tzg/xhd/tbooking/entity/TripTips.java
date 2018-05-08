package com.tzg.xhd.tbooking.entity;

import java.io.Serializable;

/**
 * 描述:trip_tips表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-08
 */
public class TripTips implements Serializable {
    /**
     * 旅游攻略表id
     */
    private Integer id;

    /**
     * 对应城市的id
     */
    private Integer cityId;

    /**
     * xx城市第n日(旅游攻略)
     */
    private String name;

    /**
     * 旅游路线(包含景点时间)
     */
    private String route;

    /**
     * 景点之间的路程时间(逗号隔开)
     */
    private String spitTime;

    /**
     * 游玩攻略
     */
    private String scenicTips;

    /**
     * 交通攻略
     */
    private String trafficTips;

    /**
     * 门票攻略
     */
    private String ticketTips;

    /**
     * 餐饮攻略
     */
    private String foodTips;

    /**
     * 住宿攻略
     */
    private String hotelTips;

    /**
     * trip_tips
     */
    private static final long serialVersionUID = 1L;

    /**
     * 旅游攻略表id
     * @return id 旅游攻略表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 旅游攻略表id
     * @param id 旅游攻略表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * xx城市第n日(旅游攻略)
     * @return name xx城市第n日(旅游攻略)
     */
    public String getName() {
        return name;
    }

    /**
     * xx城市第n日(旅游攻略)
     * @param name xx城市第n日(旅游攻略)
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 旅游路线(包含景点时间)
     * @return route 旅游路线(包含景点时间)
     */
    public String getRoute() {
        return route;
    }

    /**
     * 旅游路线(包含景点时间)
     * @param route 旅游路线(包含景点时间)
     */
    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    /**
     * 景点之间的路程时间(逗号隔开)
     * @return spit_time 景点之间的路程时间(逗号隔开)
     */
    public String getSpitTime() {
        return spitTime;
    }

    /**
     * 景点之间的路程时间(逗号隔开)
     * @param spitTime 景点之间的路程时间(逗号隔开)
     */
    public void setSpitTime(String spitTime) {
        this.spitTime = spitTime == null ? null : spitTime.trim();
    }

    /**
     * 游玩攻略
     * @return scenic_tips 游玩攻略
     */
    public String getScenicTips() {
        return scenicTips;
    }

    /**
     * 游玩攻略
     * @param scenicTips 游玩攻略
     */
    public void setScenicTips(String scenicTips) {
        this.scenicTips = scenicTips == null ? null : scenicTips.trim();
    }

    /**
     * 交通攻略
     * @return traffic_tips 交通攻略
     */
    public String getTrafficTips() {
        return trafficTips;
    }

    /**
     * 交通攻略
     * @param trafficTips 交通攻略
     */
    public void setTrafficTips(String trafficTips) {
        this.trafficTips = trafficTips == null ? null : trafficTips.trim();
    }

    /**
     * 门票攻略
     * @return ticket_tips 门票攻略
     */
    public String getTicketTips() {
        return ticketTips;
    }

    /**
     * 门票攻略
     * @param ticketTips 门票攻略
     */
    public void setTicketTips(String ticketTips) {
        this.ticketTips = ticketTips == null ? null : ticketTips.trim();
    }

    /**
     * 餐饮攻略
     * @return food_tips 餐饮攻略
     */
    public String getFoodTips() {
        return foodTips;
    }

    /**
     * 餐饮攻略
     * @param foodTips 餐饮攻略
     */
    public void setFoodTips(String foodTips) {
        this.foodTips = foodTips == null ? null : foodTips.trim();
    }

    /**
     * 住宿攻略
     * @return hotel_tips 住宿攻略
     */
    public String getHotelTips() {
        return hotelTips;
    }

    /**
     * 住宿攻略
     * @param hotelTips 住宿攻略
     */
    public void setHotelTips(String hotelTips) {
        this.hotelTips = hotelTips == null ? null : hotelTips.trim();
    }
}