package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.provider.service.EmailService;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;

/**
 * Created by Yangxq on 2016/8/30.
 */
@Service
public class EmailServiceImpl implements EmailService {

    private Logger log = Logger.getLogger(EmailServiceImpl.class);

    @Resource
    JavaMailSenderImpl mailSender;


    public boolean senderTextMail(String emailSubject, String[] emailTo,
                                  String emailText) {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        log.info("发送邮件给" + emailTo);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "utf-8");
            helper.setFrom("18329029859@163.com");// 设置发件人
            helper.setTo(emailTo);// 设置收件人

//            helper.setCc(cc);// 设置抄送
            helper.setSubject(emailSubject);// 设置主题
            helper.setText(emailText);// 邮件体
            mailSender.send(mailMessage);// 发送邮件
            log.info("邮件发送成功...");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }



    @Override
    public boolean SenderHtmlMail(String emailSubject, String emailTo, String emailText) {
        return false;
    }

//    /**
//     * @param emailSubject �ʼ�����
//     * @param emailTo      Ⱥ�����ŵ�ַ
//     * @param emailText    �ʼ�����
//     * @return
//     */
//    public boolean SenderTextMail(String emailSubject, String[] emailTo,
//                                  String emailText) {
//
//        SimpleMailMessage msg = new SimpleMailMessage(mailMessage);
//        try {
//            msg.setSubject(emailSubject);
//            msg.setTo(emailTo);
//            msg.setText(emailText);
//            mailSender.send(msg);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.debug(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean SenderHtmlMail(String emailSubject, String emailTo,
//                                  String emailText) {
//        // JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
//        // mailSender.setHost("smtp.126.com");
//        try {
//
//            mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper minHelper = new MimeMessageHelper(mimeMessage,
//                    true, "utf-8");
//
//            minHelper.setTo(emailTo);
//            minHelper.setFrom("freesmiles@126.com");
//
//            minHelper.setSubject(emailSubject);
//            minHelper.setText(emailText, true);
//            Properties prop = new Properties();
//            // ������������Ϊtrue���÷�����������֤,��֤�û����������Ƿ���ȷ
//            prop.put("mail.smtp.auth", "true");
//            // ��ʱʱ��
//            prop.put("mail.smtp.timeout", "25000");
//
//            // ������֤
//            MyAuthenticator auth = new MyAuthenticator("freesmiles@126.com",
//                    "daikuan123");
//
//            Session session = Session.getDefaultInstance(prop, auth);
//            mailSender.setSession(session);
//
//            mailSender.send(mimeMessage);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.debug(e.getMessage());
//            return false;
//        }
//    }

    public class MyAuthenticator extends Authenticator {
        private String username;
        private String password;

        public MyAuthenticator(String username, String password) {
            super();
            this.username = username;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}
