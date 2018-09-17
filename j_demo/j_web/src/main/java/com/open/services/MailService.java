package com.open.services;

import com.open.javabean.MailRequest;

/**
 * 邮件发送
 *
 * @author jm
 * @date 2018/9/4
 */
public interface MailService {

    /**
     * 邮件发送
     *
     * @param mailRequest 接收参数
     */
    void mailSend(MailRequest mailRequest);

}
