package com.tzg.xhd.tbooking.javaTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Map;

public class logTest {
    private final static Logger logger = LoggerFactory.getLogger(logTest.class);
    public static void main(String[] args){
        String result = "{\"alipay_trade_query_response\":{\"code\":\"10000\",\"msg\":\"Success\",\"buyer_logon_id\":\"htt***@sandbox.com\",\"buyer_pay_amount\":\"0.00\",\"buyer_user_id\":\"2088102175975944\",\"buyer_user_type\":\"PRIVATE\",\"invoice_amount\":\"0.00\",\"out_trade_no\":\"201804171725125\",\"point_amount\":\"0.00\",\"receipt_amount\":\"0.00\",\"send_pay_date\":\"2018-04-17 17:26:00\",\"total_amount\":\"10.00\",\"trade_no\":\"2018041721001004940200360462\",\"trade_status\":\"TRADE_SUCCESS\"},\"sign\":\"jz0x6ig5i5mW0XM0JO6QJceDaKNbZt+X1X8EID7dYytLNQeuXnCPddjHcqTAoU29zbd8TciQm0Iq8EL92lV643ZVkkN08I1BmM8AYx+PUsk5K7pvsdEsQjnKLjN1XVi7qZGD85YaFapAXcH5urV766wCTlvNqrpkW4fZTIUraA2OkFV4hM6XhlU6nWrjCVsqGKBtIxkxEDRmZUshvmsMTjcwjVkz2aqDqhJBxYyOKjDRlNQbqbPEo3lILOsTwS4soN8Wm5xfp5rlMnJ3jo8EkQ+DSAvc/5nDFgMmAxI7asS9aQf61SJVUQsICG42tAOTuxg7D03yu2cbLOMmtP5QkQ==\"}";
//        JSONArray jsonArray = JSONObject.parseArray(result);
        Map map = (Map)JSONObject.parseObject(result);
        Map a = (Map)map.get("alipay_trade_query_response");
        System.out.print(a.get("trade_status"));
    }
}
