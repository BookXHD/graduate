package com.tzg.xhd.tbooking.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // APPID
    public static String app_id = "2016091000480210";

    // 应用私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC0sDSoEacx5fb2eOTPLg0xU6P9SoFq6RFBOwDKiW1S5+w/At3rkz13DNTTUoNYSIVVs/Wsm9faolMNrGsMHqbaiuQb2YKwtbSnmwywUu/by8D9QRuJP1Ambrnll6JyFQcrJOiU3zoPgaTnDLpNtnPvU+0LmpEY5q3emFBIsdCWn+x+6VFxNcwrtQWh7NPE9wZGAB9g7UT2/7qKDv2te8VCfaNXfGhyDHI7jFZA+2ShaVx+jXqdTNg1K/Sv8Iz6kmUo7Dzz2SIN+KuuYY7rGUYE6XHtloG8QNucX4hpkpRfGSgpAJ/B6e7qnWs6u/iAtI9GbMeWP8VoYtVHCnokWdglAgMBAAECggEAQyXUe70LuFRwwcnNplzD1Ffz8nZUwAlbOzWVJq+JrCy6M/R5ykkOp4ZiNSJN42oX+vCE1R+ZSQvX95Xitj9R3JePC/Z6RfdQ6pSJU6GOt8zxrGwcspWP0KiHdxYx7Vl5L4Ro1qJablbMlHy7Y5PxY7h5uD05vNpFNRq/gzRpgv/NxO3MaA9lRZtqaZUoLgEB0xPQD+Sc+3qtyVDfOmcXtua5eaKbbvA4UahaHkDa4SG20divVVXVp3QeKPJZ9wupHnXqmfTto624IDnl+fVWrR5tmTMhIuijaOUA+AoVAtv8i5KgBkoyYRYwXiKAu9pw5VABvJmuCg5BfhoK0Yr1RQKBgQDYqA0KFuDvC6hwmKvFbmtwdmFVZOwBuNbyJ2RoqbAs7r3jdnremjs6Z1kOt8cNVZMCcaeisjYSfH3any3Yb3QrjX14S4fWKP2vpnsXSPvCf7W6giMe71v50/wBT9pN0syw0aN9Qwe7Q5hzJwAbDQvMhV/V/QOzdK0YD0fogz6m1wKBgQDVgBBI2NCRA35YNToZoBnANlbkGOdShm1i8SYqu7oqjxHOcZN27XwFrmqB8LVam37QqcsEWVFqFPMfUgTn2CiTqm6JSqhFMURQBr5oNE/l0O8c6L84e18lDy1i025ULoHj6ny0PqMLI6pmXhoUBasWHESGwagDaEPwchILeAflYwKBgQCQJG5YchRAtg7gqpJNjkMo1Xm4aKakFqfa/95Ly+mMW2I2fVMN2qrhFnUn15k1A+QE0jznf41+CxloZFMKFkzB1SbO6+F52Fe/jxGB0mq9Yl4zsfVP1Yvp0OFutgPVlxPb5/3PjtMMAdLheecWGD3rWikCo4zczhmDUldTGE6MjQKBgHLO3PLvdKimgkiYxteE2pQcJHmgUrR0CVqNZwLP1HqSWPb06GGpr2m2sxuQ/1TsDTPUOpHqHfe3sE2FY5HxEVDm823ssbQTnDKUjcunZdellQ+ssTeEUFOzZ6qfG9M09zBCpjCfBjo1Qaquq8NckPXg2ZDFjr3WUcJ49O8p6sUVAoGAB/csmkyoJ2f720yWZWwU2J/76p9CDqNxLbbjSXOBEWP850H6sMe9mEEed02qkm+m0q2C9pZTpJFi1TQNUyahBP1tkSVOPI4o8oyLCj7JJ1elhclH87i+058lHeX+sTEH7krldXJ5JiqJzhcxFg7Q/6X98iZ4uqMx1456MNxWBso=";

    // 支付宝公钥
    public static String alipay_public_key = "\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw4JWCIMz3ej+oUHRlh5vJOKyCtrbAjHd0JzAprm8jUzL0pv60+hU90a1c6yXVAqQUCchVKEsc2OhSCmntbe3zlrNQoHRf5koe1NDxcK9orehUjNdIKnSFRMCjx+IppLuFlATi39Cn2apC7GG8RJ3mrnnsmw2Gcxb2RGbTadJU60evI5PCBCpAOccgltNPQwwtKXFCBG0rqCdTpMraQrvaJLLcVBuu68PzkpuRHrbXeOodquDQVnaGVuDVIWetS7lYnb6ObXFkaSRoD2HIJib6alTu6fQSnHjm67jewUJWTIUxpbTNmOJGkBxQF6xY633QAs5dbg9+5yuy6OUjo6MuwIDAQAB";

    // 服务器 异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝系统验证支付成功之后的异步返回通知
    public static String notify_url = "http://localhost:8081/tripPlan/shopIndex";

    // 页面跳转 同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 用户确认支付后的跳转页面
    public static String return_url = "http://localhost:8081/tripPlan/payed";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志输出路径
    public static String log_path = "D:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
