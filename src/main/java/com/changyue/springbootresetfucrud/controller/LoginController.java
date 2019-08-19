package com.changyue.springbootresetfucrud.controller;

import com.changyue.springbootresetfucrud.exception.UserNotException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: spring-boot-restful-crud
 * @description: 用户控制器
 * @author: YuanChangYue
 * @create: 2019-08-13 17:59
 */
@Controller
public class LoginController {

    /**
     * 用户登录
     *
     * @param username    用户名   默认测试 123
     * @param password    密码     默认测试 123
     * @param map         map
     * @param httpSession session
     * @return 页面名称
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession) {
        if ("123".equals(username) && "123".equals(password)) {
            //将用户名放入session中，拦截器会根据这判断是否登录，从而进行拦截
            httpSession.setAttribute("loginUser", username);
            //防止表单的重复提交
            return "redirect:/main.html";
        } else {
            //错误信息
            map.put("msg", "密码或者账号错误");
            return "login";
        }
    }

    /**
     * 测试
     *
     * @param user 测试用户名：aa
     * @return Exception or String
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aa")) {
            throw new UserNotException();
        }
        return "hello";
    }

}
