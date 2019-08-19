package com.changyue.springbootresetfucrud.controller;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @program: spring-boot-restful-crud
 * @description: 自定义ErrorAttributes
 * @author: YuanChangYue
 * @create: 2019-08-19 15:02
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * @return 页面和json获取的字段
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("owner", "ChangYue");
        //自定义需要的传递的数据
        Map<String, Object> exc = (Map<String, Object>) webRequest.getAttribute("exc", 0);
        errorAttributes.put("exc", exc);
        return errorAttributes;
    }

}
