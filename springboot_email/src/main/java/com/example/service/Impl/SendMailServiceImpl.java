package com.example.service.Impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailServiceImpl implements SendMailService {

    /**
     * 简单邮件
     */
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Value("${spring.mail.username}")
//    private String sendemail;
//
//    @Override
//    public void sendMail() {
//
//        SimpleMailMessage message=new SimpleMailMessage();
//        message.setFrom(sendemail);
//        message.setTo("2052772598@qq.com");
//        message.setText("正文内容");
//        message.setSubject("测试邮件");
//        javaMailSender.send(message);
//
//    }

    /**
     * 多部件邮件
     */
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendemail;

    @Override
    public void sendMail() {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom(sendemail+"(官方)");
            helper.setTo("2052772598@qq.com");
            helper.setText("<a href='https://www.itcast.cn'>点开有惊喜</a>",true);
            helper.setText("");
            helper.setSubject("aaaa");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
