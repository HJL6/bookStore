package com.bookstore.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    public static void sendMail(String email, String emailMsg)
            throws AddressException, MessagingException {
        //Properties对象
        Properties props = new Properties();
        //设置邮件传输协议为SMTP
        props.setProperty("mail.transport.protocol", "SMTP");
        //设置优先服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        //邮件服务器验证，需要验证为true
        props.setProperty("mail.smtp.auth", "true");
        //定义验证信息
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("153887677@qq.com", "cycdbwqhtfxmbhej");
            }
        };
       //创建会话：和邮件服务器的会话
        Session session = Session.getInstance(props, auth);
        //设置发送邮件的发送信息
        Message message = new MimeMessage(session);
        //设置发送方
        message.setFrom(new InternetAddress("153887677@qq.com"));
        //设置接收方，即传过来的邮箱
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
        //设置邮件的主题
        message.setSubject("用户激活");
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
        //设置邮件内容的编码方式
        message.setContent(emailMsg, "text/html;charset=utf-8");


        Transport.send(message);
    }

}
