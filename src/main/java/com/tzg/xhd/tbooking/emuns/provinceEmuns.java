package com.tzg.xhd.tbooking.emuns;

public enum provinceEmuns {
    ZHIXIASHI(0,"直辖市"),
    ZHEJIANG(1,"浙江"),
    JIANGSU(2,"江苏"),
    SICHUAN(3,"四川"),
    SHANXI(4,"陕西");

    private Integer id;
    private String name;

    provinceEmuns(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public provinceEmuns getEnumsById(Integer id) {
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameById(Integer id){
        return getEnumsById(id).getName();
    }
}
