package com.open.controller;

import com.open.exception.MyException;
import com.open.javabean.User;
import com.open.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/19
 * @ Description：
 * @ throws
 */
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginUser")
    public String login(User user) throws MyException {
        User loginUser = loginService.login(user);
        return loginUser.toString();
    }
}
