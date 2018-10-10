package com.open.controller;

import com.open.javabean.Stu;
import com.open.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/10
 * @ Description：
 * @ throws
 */

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public List<Stu> test(){
        List<Stu> stuList = testService.getAll();
        System.out.println("heihei///");
        return stuList;
    }

}
