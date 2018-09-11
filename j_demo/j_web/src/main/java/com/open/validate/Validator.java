package com.open.validate;

import com.open.exception.MyException;

import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：校验参数
 * @ throws
 */
public class Validator {

    public static void registerValitor(Map map) throws MyException {
        if (map.get("tel") == ""){
            throw  new MyException("手机号不得为空!");
        }
        if (map.get("name") == ""){
            throw  new MyException("用户名不得为空!");
        }
        if (map.get("password") == ""){
            throw  new MyException("密码不得为空!");
        }
    }
}
