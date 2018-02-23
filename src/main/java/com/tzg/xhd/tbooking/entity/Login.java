package com.tzg.xhd.tbooking.entity;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable {
    /**id主键**/
    private Integer id;

    /**登录账号**/
    private String loginName;

    /**登录密码**/
    private String password;

    /**联系方式**/
    private String phone;

    /**创建日期**/
    private Date dtCreate;

    /**修改日期**/
    private Date dtModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getDtModify() {
        return dtModify;
    }

    public void setDtModify(Date dtModify) {
        this.dtModify = dtModify;
    }
}
