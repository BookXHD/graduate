package com.tzg.xhd.tbooking.util;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Filename:    CheckBeanUtil.java
 * Description: 校验object字段的值是否为空,空返回true,list 需要校验的必填字段
 * Copyright:   Copyright (c) 2015-2018 All Rights Reserved.
 */
public  class CheckBeanUtil {
    public static boolean chenkBean(Object obj, List<String> list) throws IllegalAccessException {
        if(obj != null) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (list.contains(field.getName()))
                    if (field.get(obj) == null || StringUtils.isBlank(String.valueOf(field.get(obj)))){
                        return true;
                    }
            }
        }
        return false;
    }
}
