package com.open.services.iml;

import com.open.exception.MyException;
import com.open.javabean.User;
import com.open.mappers.RegisterMapper;
import com.open.services.RegisterUserService;
import com.open.utils.PasswordUtils;
import com.open.validate.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：注册
 * @ throws
 */
@Service
public class RegisterUserImpl implements RegisterUserService {

    public static final Logger logger = LoggerFactory.getLogger(RegisterUserImpl.class);

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int registerUser(User user) throws MyException {

        Map<String, Object> map = new HashMap<>();
        map.put("tel", user.getTel());
        map.put("name", user.getName());
        map.put("password", user.getPassword());

        try {
            Validator.registerValitor(map);
        } catch (MyException e) {
            e.printStackTrace();
            throw new MyException("字段类型不得为空!");
        }

        //已经使用过的手机号、用户名不再允许注册
        String tel = user.getTel();
        String name = user.getName();
        List<User> userList = registerMapper.seachByTelAndName(tel, name);

        if (userList.size() > 0){
            logger.info(userList.toString());
            throw new MyException("注册的用户信息已存在,请核对申请的信息!");
        }

        String password = user.getPassword();
        String md5Password = PasswordUtils.MD5(password);
        user.setPassword(md5Password);

        //新建条数
        int i = registerMapper.registerUser(user);
        return i;
    }
}
