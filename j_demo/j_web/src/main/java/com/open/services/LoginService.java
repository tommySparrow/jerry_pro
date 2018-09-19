package com.open.services;

import com.open.javabean.User;

public interface LoginService {
    /**
     * 登录
     * */
    User login(User user);
}
