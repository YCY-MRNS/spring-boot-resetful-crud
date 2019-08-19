package com.changyue.springbootresetfucrud.controller;

import com.changyue.springbootresetfucrud.exception.UserNotException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-restful-crud
 * @description: 异常处理器
 * @author: YuanChangYue
 * @create: 2019-08-19 12:53
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理UserNotException
     * 注意：一定要设置错误代码
     * 根据：org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController#getStatus(javax.servlet.http.HttpServletRequest)
     * 关键点：request.setAttribute("javax.servlet.error.status_code", 500);
     *
     * @return 处理信息
     */
    @ExceptionHandler(UserNotException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入错误代码 4xx 5xx
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        request.setAttribute("exc", map);
        return "forward:/error";
    }

}
