package com.lw.common.utils;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MialSenderUtils {
  
  /**
   * 实现邮件的发送
   * @param subject:邮件主题
   * @param content:邮件正文
   * @param address:邮件发送用户账号
   * @throws GeneralSecurityException
   * @throws MessagingException
   */
  public static void sendMail(String subject, String content, String address) throws GeneralSecurityException, MessagingException {
    Properties props = new Properties();

    // 开启debug调试
    props.setProperty("mail.debug", "true");
    // 发送服务器需要身份验证
    props.setProperty("mail.smtp.auth", "true");
    // 设置邮件服务器主机名
    props.setProperty("mail.host", "smtp.qq.com");
    // 发送邮件协议名称
    props.setProperty("mail.transport.protocol", "smtp");

    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    props.put("mail.smtp.ssl.enable", "true");
    props.put("mail.smtp.ssl.socketFactory", sf);

    Session session = Session.getInstance(props);

    Message msg = new MimeMessage(session);
    msg.setSubject(subject);
    StringBuilder builder = new StringBuilder();
    builder.append(content);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    builder.append("/n时间: " + simpleDateFormat.format(new Date()));
    msg.setText(builder.toString());
    msg.setFrom(new InternetAddress("755151050@qq.com"));

    Transport transport = session.getTransport();
    transport.connect("smtp.qq.com", "755151050@qq.com", "ecbbxhhrufilbdgf");
    transport.sendMessage(msg, new Address[] { new InternetAddress(address) });
    transport.close();
  }
}
