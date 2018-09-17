package com.open.services.iml;

import com.open.javabean.MailRequest;
import com.open.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Description: 邮件发送
 * @Author: jm
 * @Date: 2018/8/29 16:20
 */
@Service
public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${mail.from.username}")
    public String mailFromUsername;

    @Value("${mail.from.password}")
    public String mailFromPassword;

    @Value("${mail.smtp.host}")
    public String mailSmtpHost;

    @Value("${mail.smtp.port}")
    public String mailSmtpPort;

    @Value("${mail.smtp.starttls.enable}")
    public String mailSmtpStarttlsEnable;

    @Value("${mail.smtp.auth}")
    public String mailSmtpAuth;


    @Override
    public void mailSend(MailRequest mailRequest) {

        //获取当前年月日
        String currentDate = "20180917";
        //邮件主题
        String mailTheme = "机构分润通知" + currentDate;
        //邮件内容
        String mailContent = "您好," + currentDate + mailRequest.getCode() + mailRequest.getName() + "分润奖励生成完成，请查看！";

        Properties props = new Properties();

        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.port", mailSmtpPort);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailFromUsername, mailFromPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(mailFromUsername));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailRequest.getToAddress()));//收件地址
            message.setSubject(mailTheme);//主题
            message.setText(mailContent);//内容

            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.error("邮件发送失败,失败原因:{}!", e.getMessage());
        }
    }
}
