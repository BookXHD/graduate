package com.tzg.xhd.tbooking.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 描述:city表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-12
 */
@Table(name = "city")
public class City implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 城市名字
     */
    private String name;

    /**
     * 城市名字拼音
     */
    private String nameStr;

    /**
     * 所属省份
     */
    private Integer province;

    /**
     * 城市图片保存地址
     */
    private String img;

    /**
     * 面积（平方千米）
     */
    private Integer area;

    /**
     * 人口（万）
     */
    private Integer population;

    /**
     * 城市历史年数
     */
    private Integer age;

    /**
     * 历史文化描述
     */
    private String history;

    /**
     * 气候环境描述
     */
    private String weather;

    /**
     * 美食特产描述
     */
    private String food;

    /**
     * 人文风俗描述
     */
    private String cultural;

    /**
     * 相关影视
     */
    private String movie;

    /**
     * 相关书籍描述
     */
    private String book;

    /**
     * city
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 城市名字
     * @return name 城市名字
     */
    public String getName() {
        return name;
    }

    /**
     * 城市名字
     * @param name 城市名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 城市名字拼音
     * @return name_str 城市名字拼音
     */
    public String getNameStr() {
        return nameStr;
    }

    /**
     * 城市名字拼音
     * @param nameStr 城市名字拼音
     */
    public void setNameStr(String nameStr) {
        this.nameStr = nameStr == null ? null : nameStr.trim();
    }

    /**
     * 所属省份
     * @return province 所属省份
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 所属省份
     * @param province 所属省份
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 城市图片保存地址
     * @return img 城市图片保存地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 城市图片保存地址
     * @param img 城市图片保存地址
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 面积（平方千米）
     * @return area 面积（平方千米）
     */
    public Integer getArea() {
        return area;
    }

    /**
     * 面积（平方千米）
     * @param area 面积（平方千米）
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 人口（万）
     * @return population 人口（万）
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * 人口（万）
     * @param population 人口（万）
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * 城市历史年数
     * @return age 城市历史年数
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 城市历史年数
     * @param age 城市历史年数
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 历史文化描述
     * @return history 历史文化描述
     */
    public String getHistory() {
        return history;
    }

    /**
     * 历史文化描述
     * @param history 历史文化描述
     */
    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    /**
     * 气候环境描述
     * @return weather 气候环境描述
     */
    public String getWeather() {
        return weather;
    }

    /**
     * 气候环境描述
     * @param weather 气候环境描述
     */
    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    /**
     * 美食特产描述
     * @return food 美食特产描述
     */
    public String getFood() {
        return food;
    }

    /**
     * 美食特产描述
     * @param food 美食特产描述
     */
    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    /**
     * 人文风俗描述
     * @return cultural 人文风俗描述
     */
    public String getCultural() {
        return cultural;
    }

    /**
     * 人文风俗描述
     * @param cultural 人文风俗描述
     */
    public void setCultural(String cultural) {
        this.cultural = cultural == null ? null : cultural.trim();
    }

    /**
     * 相关影视
     * @return movie 相关影视
     */
    public String getMovie() {
        return movie;
    }

    /**
     * 相关影视
     * @param movie 相关影视
     */
    public void setMovie(String movie) {
        this.movie = movie == null ? null : movie.trim();
    }

    /**
     * 相关书籍描述
     * @return book 相关书籍描述
     */
    public String getBook() {
        return book;
    }

    /**
     * 相关书籍描述
     * @param book 相关书籍描述
     */
    public void setBook(String book) {
        this.book = book == null ? null : book.trim();
    }
}