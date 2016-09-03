package com.yangxq.monitor.provider.service;

/**
 * Created by Yangxq on 2016/8/30.
 */
public interface EmailService {

    /**
     * 发送单人文本邮件
     * @param emailSubject
     * @param emailTo
     * @param emailText
     * @return
     */
     boolean senderTextMail(String emailSubject,  String[] emailTo,
                                  String emailText);



    /**
     * 发送html格式邮件
     * @param emailSubject
     * @param emailTo
     * @param emailText
     * @return
     */
     boolean SenderHtmlMail(String emailSubject, String emailTo,
                                  String emailText) ;
}
