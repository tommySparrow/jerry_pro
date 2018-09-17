package com.open.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/17
 * @ Description：Redis Demo 测试类
 * @ throws
 */

@RestController
@RequestMapping
public class RedisTest {

    @Autowired
    private Jedis jedis;

    @RequestMapping("/redis")
    public void redisDemo(){

        String s = jedis.set("hi", "hello world");
        System.out.println(s+"测试Redis的使用");
        String hi = jedis.get("hi");
        System.out.println(hi+"返回值测试");

        // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
        jedis.set("hello", "world", "NX", "EX", 10);
    }
}
