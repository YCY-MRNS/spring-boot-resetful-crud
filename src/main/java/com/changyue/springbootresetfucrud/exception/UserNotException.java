package com.changyue.springbootresetfucrud.exception;

/**
 * @program: spring-boot-restful-crud
 * @description: 用户不存在异常类
 * @author: YuanChangYue
 * @create: 2019-08-19 12:44
 */
public class UserNotException extends RuntimeException {
    public UserNotException() {
        super("用户不存在");
    }
}
