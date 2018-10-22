package com.open.services.iml;

import com.open.exception.MyException;
import com.open.javabean.User;
import com.open.mappers.LoginMapper;
import com.open.security.AccountToken;
import com.open.services.LoginService;
import com.open.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/19
 * @ Description：
 * @ throws
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User login(User user){
        String password = user.getPassword();
        String md5 = PasswordUtils.MD5(password);
        user.setPassword(md5);
        //shiro 开始
        Subject subject = SecurityUtils.getSubject();
        AccountToken token = new AccountToken(user.getName(), user.getPassword(), false);
        subject.login(token);
        //shiro 结束
        List<User> userList = loginMapper.select(user);
        if (userList.size()< 1){
            try {
                throw  new MyException("没有查询到用户");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        if (userList.size()> 1){
            try {
                throw  new MyException("查到了多个用户");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return userList.get(0);
    }
}
