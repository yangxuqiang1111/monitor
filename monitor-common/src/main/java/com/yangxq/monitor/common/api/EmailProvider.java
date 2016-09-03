package com.yangxq.monitor.common.api;

/**
 * Created by Yangxq on 2016/8/30.
 */
public interface EmailProvider {
    /**
     * 发送多人文本邮件
     * @param emailSubject
     * @param emailTo
     * @param emailText
     * @return
     */
    boolean senderTextMail(String emailSubject,  String[] emailTo,
                           String emailText);
}
