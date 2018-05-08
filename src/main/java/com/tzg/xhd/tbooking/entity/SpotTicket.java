package com.tzg.xhd.tbooking.entity;

import java.io.Serializable;

/**
 * 描述:spot_ticket表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-08
 */
public class SpotTicket implements Serializable {
    /**
     * 景点门票id
     */
    private Integer id;

    /**
     * 对应的旅游攻略id
     */
    private Integer tripTipsId;

    /**
     * 门票名字
     */
    private String name;

    /**
     * 门票价格
     */
    private Integer price;

    /**
     * 景点门票介绍
     */
    private String introduce;

    /**
     * 景点门票图片
     */
    private String img;

    /**
     * spot_ticket
     */
    private static final long serialVersionUID = 1L;

    /**
     * 景点门票id
     * @return id 景点门票id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 景点门票id
     * @param id 景点门票id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 对应的旅游攻略id
     * @return trip_tips_id 对应的旅游攻略id
     */
    public Integer getTripTipsId() {
        return tripTipsId;
    }

    /**
     * 对应的旅游攻略id
     * @param tripTipsId 对应的旅游攻略id
     */
    public void setTripTipsId(Integer tripTipsId) {
        this.tripTipsId = tripTipsId;
    }

    /**
     * 门票名字
     * @return name 门票名字
     */
    public String getName() {
        return name;
    }

    /**
     * 门票名字
     * @param name 门票名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 门票价格
     * @return price 门票价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 门票价格
     * @param price 门票价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 景点门票介绍
     * @return introduce 景点门票介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 景点门票介绍
     * @param introduce 景点门票介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 景点门票图片
     * @return img 景点门票图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 景点门票图片
     * @param img 景点门票图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}