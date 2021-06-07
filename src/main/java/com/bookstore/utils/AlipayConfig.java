package com.bookstore.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117658855";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCP9olDxI0EVrTqoUnfsAX0YD9regiYatSyp5sDW114vW7ZmHPoL2YvEhKcToNq7D2SNOQ/A6JP5S3w126RLXFnFTWAo8kaW3edq+N0kxzwGEOD9FVsXbF4FX47svJR7gcyRmGNyLk82KyoMz+MIwZElMp3BV90dm5meX5taMK65HJkZOqqNFQFTv92LxJVOwMWvroPbg5cAknG2df1xEMJH1Gc1PlI2eLCMcpZwrfYdw/aoi0ebuzIZKVNXvVKwbvTD3rwMLso/WxHrKK/HXwz6z1YsK7nI5UUUKmtNjVkDjtObJRDgs0yQjJ1az0kkQ191UQR8Hpab/wO/J4e/v5HAgMBAAECggEAaslgFnGkfLRobKaJKrDiKdx/DpUt7QlJjt/+fyX1lstFf4izaWZHcOECBwnCN7zXCy3KpOdoLcV9J2pV7MB9nw4/apWTZca1WrKW/PDnBT2qTyYde02gh8fBpDzfvGBI3EUStd5PcU/z+qxRFf0g+Bw6dsD4hmYXDFJQso2D7KbJn2s+E7bZNPsWR9SegtdK2UuHlncTqJFUkZm+QF8yv1WjaIgY8REpui2daBDmi7b3796ITao+fi8/OzOl9FNTp1UkL7YaZ8KxRMZHNZJCIPXQNU2UgLtqJr8kB/StFxcZtBsEnKVbcKVuXM3DqSuGeM2GmgWio6yD98Gyy06qKQKBgQDhpXH4h0hqG+lv+dTyuKlgNLL/8dPKZ2rWBhGza/v113JqeZdkAG27o7SSkX8JFBlKVwaqOuszTD+PmoGarXwvy93ksl5BKhhEG+ARQ4JkNNr57okbJj0eFogZaZHjTY0QmXGENlLQsmB8eXAC/0cfUXe3segZ6Uu0qeJYOni5tQKBgQCjVCy2TwZ99pTZOMtEyacg9zalbNvf+bnhjnUeVDKbd11cLkEpXT53IqnQMePLbq839Rl9pzhlz1b75HzSE1XyF4D7GScmNTF0/thOdPqIUhlyTaEdM6zH4KOxDOL/T8Wt++ff5RzcBgqB1UOzpnmuB9xn9mo6QYe/G3lavw8liwKBgAKlz1WMONRN6YpP0yjZ89rWI3ePXd3VItLKFXEWhklXMtd+/8DDpIX8IMVLgcMYgkd2B/T9Zf8fGOvVc0neWUOyT7M8SJDZLpm1/gYV1bTZTex62Q8BftwYhZZOv9B7+3jDZCqZ/JTIUwuC3Uabujjq2s3D/6Y2L5Y6HBbO8NW1AoGAYOe8b56Ll4kJ36gW0oVip+iFf7kK6+TbKLzBOHF0ZVF5DwxSlRxBx6XFY0V2hmjxhR3jNe5VQ/K1BVcXx/y47Z6MZG8UD1NYOLZL2KEHVIKBnpP4l77lMOJTvOSMejb2brgbZ3gkm1bqPQYv2RNY9qyrVPObK11eEUFXy0O41OkCgYBtlXImKQpuqp9FTlmFXA5bdDIu6xwOpD9+FAL213EkqODmS/LR0GECAvAJ6Laeye+FjRmcEeLD5jkMYDI6QNxnNwF+o8otJ3/XJghgsYsQJJvQB9SWTCApckSk1jRDnmKjpgzK3H7ZQM3koIl0ot8LEBnB+yJPglJzNrmC3zn6aw==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj9/yhoB+Ot3dIyifatSV8sV7Dv62E/8zxpPn4o2H5bj83/nzi6dukhw7XdZVD2mAQ2W0gIaTeHhCXtCTrqCIutbjPNUwYmw+MGYxsgWgY+XCSpeOsffsRco7kK8RqOejhkethV+KRD/FpOM7sKZ1zSQnd6WmiCOta9PRNhB6mfWUpgmdPEuqfBvuaj5wNV/BUIotkAWEIrx3ig6aqaHs/nqjbEQL7Cs7f2bEuj4VpgcXN9mFkOV2AzXzeiaqhsymS/mLFeeZqhEb4E+axXOxeMXefZGB4xRAOoXqNeLKZFEC6dt4RGQ5PDMdbbW5nR+r+iTCJcde6gEpxFbhhgdSjwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/bookstore/client/order/paysuccess";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/bookstore/client/order/paysuccess";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

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
