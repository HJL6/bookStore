package com.bookstore.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000122684784";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtdSidEZSOVdMx5bCPnjeFlhYRhaTuaj/nQrU4Rg8NwGRRJBqahVjIb81xACyuBLqPxrr3r/0ZTYPIEt1/LWQ60rnLsRy1yE6E4xo46kTRhwer6EgiGYl3UYzfnja1Xt5RJNjYItR53SOnUQcKeCd27LIoDAKa1UMjkjXzvznLF86SYONRmHuu05YIg0mH0dtAC1aCH0Dk67QKoY9aRYTLMKBKhIj/1Gjfb7bCBAot/6mKnVL7xCC6+JOPaIfZNXMm9URhEnPTkYl4Ndqy5SRkkiPxF1WyL/lfW0TgRxcgb2eB2hzwYWSRzUGt6+T/8oX6Q7WSC+q+asrsJYDu3mCFAgMBAAECggEBAJm+Bklxk6K1H4RSebRSIBQfe1/8fLt1IT7xOX6vWhhuNnxU69+Z4Z+GuSk3ZmK3fkSBeKahLkyHEA796aUXrocUz+ljCnd1G2Ndh5h6zJSKgpo0P/s5d0Zy2dI6gXMwqwxxBGJOPNXm0/sxLnRxG0mlciNcwdJKxD97EKcDD06aR06kyy41LL8X3d4v0UH6r+TMXaOLQd3zfJiVtADUNW5Krzl/1RRiWu1kP9hMgN6iLx30U1gRh5XwIbCvtA1/aKlmxT4NeBZ1s8FnoaaTya7/4gTPI0L2l7/rQVDg7EjmvMsncZbws1Df7cPHAJ8erhtzuySV7x81If/ahaC3zAECgYEA/cjUGjZTVWqF3kI8MGFumPX1EuJNZWBtENXalOHVxHIqm7DpEwzf6fZfS6jPzV5YoPkm2WBgWkiwDDMnPOXGstHf58FkUQVgGLV7gS8vAHPJeNpMPlCIvRnXAWwOKo0xDnnCDP1tQw3riH+1ENW8F8c4IzZCBcTYfJ7Wuv3I5iUCgYEArvjPse32p5r616fBaB4MuvnS16IJeA16rXKtm8bq1zfqtHFZHRVMN8Ng0O953VtlrVuuUO+85/FZqkvavrYkFdymBtKURAAFUwsGWZfIrzFeFRXxKx20g+uHJiwuyFu8ZrPz1SXRtdVzqE+48UKUA63WMvO9reGK95VaUDRvkuECgYB0b1OAwzPwmHLayiC7QbhwTUgnZdSEknz3oGYssIBXJNoPnFcS+nEw8mw+VjEg1AxtrmH4kZMjWP4MWtvBwNos6MWFmuDfm0u/imQjnPY/iuAApoccf+58dAKFEIJfW3AKaCpzs0IR5a0ObykvlCA7+Jb08MvRwcJhSq7SE+W8UQKBgQCL6W+DMuqaCWZtzbns/KJnXN9JCEwUEIs5aMsEFqKw6Aiosz5z8BTbPkMLr4K+C5iZcAdKtvlSav6tGyzWdSUTyjWEnRxr56xaRCWWvLV/ybUWnU4UkRNIrayLTKc4FYrogRsIJM61XPK38s/LM9bRvk7avWa+ROzvnyDxo4xYYQKBgEkONMwkHkhm9pVgRtmQZBM4cSiDSav4Nxb4YBp9T/yXyvjNXQiB12nNNsPa7tCEw4mrk6eXKToLFhgHtWGlLVbY0qeXZbWZNfj3b+fVNliAIfj0wK2fIDG7LLhinpSWeiJfl5ye6Oy8qSwr1j6CnecHmkGuEGZ4N9b0AFvYRuQo";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArXUonRGUjlXTMeWwj543hZYWEYWk7mo/50K1OEYPDcBkUSQamoVYyG/NcQAsrgS6j8a696/9GU2DyBLdfy1kOtK5y7EctchOhOMaOOpE0YcHq+hIIhmJd1GM3542tV7eUSTY2CLUed0jp1EHCngnduyyKAwCmtVDI5I18785yxfOkmDjUZh7rtOWCINJh9HbQAtWgh9A5Ou0CqGPWkWEyzCgSoSI/9Ro32+2wgQKLf+pip1S+8QguviTj2iH2TVzJvVEYRJz05GJeDXasuUkZJIj8RdVsi/5X1tE4EcXIG9ngdoc8GFkkc1Brevk//KF+kO1kgvqvmrK7CWA7t5ghQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url ="http://localhost:8080/client/order/paysuccess";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/client/order/paysuccess";

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
