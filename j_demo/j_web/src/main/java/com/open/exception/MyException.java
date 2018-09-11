package com.open.exception;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：自定义异常信息
 * @ throws
 */
public class MyException extends Exception{

    public MyException(String message){
        super(message);
    }
}
