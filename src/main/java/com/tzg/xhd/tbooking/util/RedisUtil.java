package com.tzg.xhd.tbooking.util;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisUtil {
    private static Jedis jedis = new Jedis("localhost",6379,60000);

    /**
     * 设置key/ 设置key对应的value
     * @param key
     * @param value
     */
    public static void setKey(String key, String value) {
        jedis.set(key,value);
    }

    /**
     * 获取对应Key的value
     * @param key
     * @return
     */
    public static String getKey(String key) {
        return jedis.get(key);
    }

    public static void main(String[] args) {
        //获取当前redis内存里所有的key及其对应的value
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key + ":" +getKey(key));
        }
    }

}
