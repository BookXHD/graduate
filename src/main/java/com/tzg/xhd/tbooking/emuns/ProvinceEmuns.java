package com.tzg.xhd.tbooking.emuns;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum ProvinceEmuns {
    ZHIXIASHI(0,"直辖市"),
    ZHEJIANG(1,"浙江"),
    JIANGSU(2,"江苏"),
    SICHUAN(3,"四川"),
    SHANXI(4,"陕西");

    private Integer id;
    private String name;

    ProvinceEmuns(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    /**
     * 根据id 获取name
     * @param id
     * @return
     */
    public static String getNameById(Integer id) {
        for (ProvinceEmuns provinceEmuns : ProvinceEmuns.values()) {
            if (id.intValue() ==(provinceEmuns.getId())) {
                return provinceEmuns.getName();
            }
        }
        return "";
    }

    /**
     * 根据name获取id
     * @param name
     * @return
     */
    public static Integer getIdByName(String name) {
        if(StringUtils.isBlank(name)){
            return null;
        }
        for(ProvinceEmuns provinceEmuns : ProvinceEmuns.values()){
            if(provinceEmuns.getName().equals(name)){
                return provinceEmuns.getId();
            }
        }

        return null;
    }

    public static ProvinceEmuns getEnum(Integer id) {
        ProvinceEmuns resultEnum = null;
        ProvinceEmuns[] enumAry = ProvinceEmuns.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (id.intValue() == enumAry[i].getId()) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<Integer, String> toKeyValueMap() {
        ProvinceEmuns[] ary = ProvinceEmuns.values();
        Map<Integer, String> enumMap = new HashMap<Integer, String>();
        for (int num = 0; num < ary.length; num++) {
            ProvinceEmuns dto = getEnum(ary[num].getId());
            enumMap.put(dto == null? null:dto.getId(), dto == null? null:dto.getName());
        }
        return enumMap;
    }
}
