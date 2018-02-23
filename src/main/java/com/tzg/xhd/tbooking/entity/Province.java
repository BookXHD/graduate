package com.tzg.xhd.tbooking.entity;

import java.io.Serializable;

public class Province implements Serializable {
    /**id主键**/
    private Integer id;
    /**省份名字**/
    private String provinceName;
    /**省份位置(方向)**/
    private String provinceDirec;
    /**省份面积**/
    private float provinceArea;

    public Integer getId() {
        return id;
    }
    public void setId(Integer provinceId) {
        this.id = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceDirec() {
        return provinceDirec;
    }
    public void setProvinceDirec(String provinceDirec) {
        this.provinceDirec = provinceDirec;
    }

    public float getProvinceArea() {
        return provinceArea;
    }
    public void setProvinceArea(float provinceArea) {
        this.provinceArea = provinceArea;
    }
}
