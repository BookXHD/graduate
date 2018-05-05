package com.tzg.xhd.tbooking.util;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;


@Slf4j
public class IPAdressUtil {
    private static final String URL = "http://api.map.baidu.com/location/ip?ak=25DCshYtzayLoBc84Lk4EMdU3XagwuX6&coor=bd09ll";

    /**
     * http调用百度地图api接口 获取当前ip所在的城市
     * @return city
     */
    public static String getCurrentCtiy() {
        String city = "";
        try {
            URL url = new URL( URL);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while((line = reader.readLine()) != null)
            {
                result.append(line);
            }
            reader.close();
            Map map1 = (Map) JSONObject.parseObject(result.toString());
            Map a = (Map)map1.get("content");
            city = a.get("address").toString();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
        return city;
    }

    public static void main(String[] args) {
        System.out.print(getCurrentCtiy());
    }


}
