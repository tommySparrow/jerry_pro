package com.open.controller;

import com.open.exception.MyException;
import com.open.javabean.User;
import com.open.services.RegisterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：注册
 * @ throws
 */
@RequestMapping
@RestController
public class RegisterUserController {

    public static final Logger logger = LoggerFactory.getLogger(RegisterUserController.class);

    @Autowired
    private RegisterUserService registerUserService;

    @RequestMapping("/registerUser")
    public int registerUser( User user) throws MyException {
        logger.info("用户:"+user);
        int i = registerUserService.registerUser(user);
        return i;
    }

}
