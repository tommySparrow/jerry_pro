package com.open.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/22
 * @ Description：用于shiro
 * @ throws
 */
public class AccountToken extends UsernamePasswordToken {

    public AccountToken(String username,String password,boolean rememberMe){
        super(username, password, rememberMe, null);
    }
}
