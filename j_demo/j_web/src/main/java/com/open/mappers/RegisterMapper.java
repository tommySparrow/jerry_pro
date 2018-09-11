package com.open.mappers;

import com.open.javabean.User;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：
 * @ throws
 */
public interface RegisterMapper {

    /**
     * 用户注册
     */
    int registerUser(User user);

}
