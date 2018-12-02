package com.bilibili.yl.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author bilibili_jiaozhu
 *
 * 邮箱工具类
 * */
public class MailUtils {
    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage mail;

    /**
     * 邮箱工具类（目前发件邮箱只支持QQ邮箱，收件邮箱无限制）
     *
     * @param myEmail 发邮箱的地址
     * @param pop3    pop3授权码，去邮箱设置里面找
     * @param email   接受邮件的邮箱
     * @param title   邮件的主题
     * @param context 邮件的内容
     */
    public MailUtils(String myEmail, String pop3, String email, String title, String context) {
        this.mailSender = new JavaMailSenderImpl();
        this.mailSender.setHost("smtp.qq.com");//qq邮箱服务器
        this.mailSender.setPort(587);//端口
        this.mailSender.setUsername(myEmail);//发送者
        this.mailSender.setPassword(pop3);//POP3/SMTP服务授权码

        this.mail = new SimpleMailMessage();
        this.mail.setTo(email);// 接受者
        this.mail.setFrom(myEmail);//发送者
        this.mail.setSubject(title);//主题
        this.mail.setText(context);// 邮件内容
    }

    /**
     * 生成随机验证码
     *
     * @param num 生成随机验证码的位数
     * @return 随机num位数的验证码
     */
    public static String createRandomNum(int num) {
        StringBuffer randomNumStr = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int randomNum = (int) (Math.random() * 10);
            randomNumStr.append(randomNum);
        }
        return String.valueOf(randomNumStr);
    }

    /**
     * 发送邮件的方法
     * <p>
     * 使用.send()方法
     */
    public void send() {
        mailSender.send(mail);
    }
}
