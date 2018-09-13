package com.open.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.open.javabean.User;
import com.open.mappers.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/13
 * @ Description：
 * @ throws
 */
@RestController
public class Test {

    @Autowired
    private RegisterMapper registerMapper;

    @RequestMapping("/user")
    public void inser(){

        User user = new User();
        user.setTel("123");
        user.setName("22");
        user.setPassword("456");
        registerMapper.insert(user);

        PageHelper.startPage(1, 3);
        List<User> list = registerMapper.seachByTelAndName("15316009635", "jack");
        PageInfo<User> userPageInfo = new PageInfo<>(list, 5);

    }

}
