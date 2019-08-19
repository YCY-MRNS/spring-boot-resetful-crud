package com.changyue.springbootresetfucrud.config;

import com.changyue.springbootresetfucrud.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: spring-boot-restful-crud
 * @description: SpringMVC 配置类
 * @author: YuanChangYue
 * @create: 2019-08-13 17:59
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer WebMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * 添加视图映射
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 添加拦截器
             * 除了登录界面,首页和静态资源
             * 其他资源进行拦截
             * 意图是验证用户是否在登录的情况下进去内部
             * @param registry
             */
         /*   @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/webjars/**");
            }*/
        };
    }

}
