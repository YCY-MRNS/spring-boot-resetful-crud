package com.changyue.springbootresetfucrud.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring-boot-restful-crud
 * @description: 登录拦截器
 * @author: YuanChangYue
 * @create: 2019-08-13 17:59
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * controller 之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得登录凭证
        Object loginUser = request.getSession().getAttribute("loginUser");
        //是否登录过
        if (loginUser == null) {
            //没有登录 拦截下来 返回登录界面
            request.setAttribute("msg", "没有权限，请登录！");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            //放行
            return true;
        }
    }
}
