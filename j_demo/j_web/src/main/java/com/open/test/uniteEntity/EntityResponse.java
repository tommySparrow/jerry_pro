package com.open.test.uniteEntity;

import java.util.HashMap;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/28
 * @ Description：返回实体类(用于多表联合查询)
 * @ throws
 */
public class EntityResponse extends HashMap {

    //record表信息
    private String account;
    //test表信息
    private String age;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
