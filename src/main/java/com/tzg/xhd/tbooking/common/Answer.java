package com.tzg.xhd.tbooking.common;

import java.io.Serializable;


/**
 * @Description: 通用交互返回对象
 * @param <T>
 * @return Answer<T>
 * @author xuhd
 */
public class Answer<T> implements Serializable {
    /**
     * 成功/失败
     */
    private boolean success;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
