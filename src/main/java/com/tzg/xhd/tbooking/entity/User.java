package com.tzg.xhd.tbooking.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:user表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-03-08
 */
@Table(name = "user")
public class User implements Serializable {
    /**
     * 用户Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录用户名
     */
    @NotEmpty(message = "用户名不能为空!")
    private String loginName;

    /**
     * 用户密码
     */
    @NotEmpty(message = "密码不能为空!")
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "请输入正确的邮箱格式!")
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证
     */
    @Length(min = 18,max = 18,message = "请输入正确的身份证号!")
    private String identity;

    /**
     * 现居住地
     */
    private String location;

    /**
     * 用户注册手机
     */
    @Length(min = 11,max = 11,message = "请输入正确的手机号!")
    private String phone;

    /**
     * 网站昵称
     */
    private String nickName;

    /**
     * 头像图片
     */
    private String picture;

    /**
     * 自我介绍
     */
    private String introduce;

    /**
     * 
     */
    private Date dtCreate;

    /**
     * 
     */
    private Date dtModify;

    /**
     * user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     * @return id 用户Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户Id
     * @param id 用户Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录用户名
     * @return login_name 登录用户名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录用户名
     * @param loginName 登录用户名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 身份证
     * @return identity 身份证
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 身份证
     * @param identity 身份证
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * 现居住地
     * @return location 现居住地
     */
    public String getLocation() {
        return location;
    }

    /**
     * 现居住地
     * @param location 现居住地
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 用户注册手机
     * @return phone 用户注册手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 用户注册手机
     * @param phone 用户注册手机
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 网站昵称
     * @return nick_name 网站昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 网站昵称
     * @param nickName 网站昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 头像图片
     * @return picture 头像图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 头像图片
     * @param picture 头像图片
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 自我介绍
     * @return introduce 自我介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 自我介绍
     * @param introduce 自我介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 
     * @return dt_create 
     */
    public Date getDtCreate() {
        return dtCreate;
    }

    /**
     * 
     * @param dtCreate 
     */
    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    /**
     * 
     * @return dt_modify 
     */
    public Date getDtModify() {
        return dtModify;
    }

    /**
     * 
     * @param dtModify 
     */
    public void setDtModify(Date dtModify) {
        this.dtModify = dtModify;
    }
}