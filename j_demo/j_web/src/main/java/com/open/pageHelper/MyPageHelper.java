package com.open.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.open.javabean.User;
import com.open.mappers.RegisterMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/17
 * @ Description：一个分页插件
 * @ throws
 */
@RestController
@RequestMapping
public class MyPageHelper {

    @Autowired
    private RegisterMapper registerMapper;


    /**
     *
     * @author chenmc 
     * @date 2018/9/17
     * @param [pageNum, pageSize, map] 
     * @return com.github.pagehelper.PageInfo<com.open.javabean.User>
     */
    @RequestMapping("/getPages")
    public Map<String, Object> getPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize) {

        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = registerMapper.getAll();

        //navigatePages-显示出来的页码(首页<<1 2 3 4 5>>尾页)
        PageInfo<User> userPageInfo = new PageInfo<>(userList, 5);
        map.put("userPageInfo", userPageInfo);
        return map;
    }
}
















