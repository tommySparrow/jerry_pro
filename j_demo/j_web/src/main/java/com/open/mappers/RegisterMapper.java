package com.open.mappers;

import com.github.abel533.mapper.Mapper;
import com.open.javabean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：
 * @ throws
 */
public interface RegisterMapper extends Mapper<User> {

    /**
     * 用户注册
     */
    int registerUser(User user);

    /**
     * 根据手机号,用户名查询对应的用户
     */
    List<User> seachByTelAndName(@Param("tel") String tel, @Param("name")String name);

}
