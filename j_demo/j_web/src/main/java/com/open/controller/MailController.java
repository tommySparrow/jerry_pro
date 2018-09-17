package com.open.controller;

import com.open.exception.MyException;
import com.open.javabean.MailRequest;
import com.open.services.MailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 邮件发送接口
 *
 * @author jm
 * @date 2018-8-30
 */
@Controller
@RequestMapping("/mail/send")
public class MailController {


    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mailSend(@RequestBody MailRequest mailRequest) throws MyException {
        if (StringUtils.isEmpty(mailRequest.getCode()) || StringUtils.isEmpty(mailRequest.getName()) || StringUtils.isEmpty(mailRequest.getToAddress())) {
            throw new MyException("缺少参数!");
        }

        mailService.mailSend(mailRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
