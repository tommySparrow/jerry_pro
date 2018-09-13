package com.open.services;

import com.open.exception.MyException;
import com.open.javabean.User;

public interface RegisterUserService {
    int registerUser(User user) throws MyException;
}
