package com.yangxq.monitor.provider.impl;

import com.yangxq.monitor.common.api.EmailProvider;

/**
 * Created by Yangxq on 2016/8/30.
 * 发送邮件服务
 */
public class EmailProviderImpl extends BaseProviderImpl implements EmailProvider {

    @Override
    public boolean senderTextMail(String emailSubject, String[] emailTo, String emailText) {
        return emailService.senderTextMail(emailSubject,emailTo,emailText);
    }
}
