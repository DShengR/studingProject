package com.dsr.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * SpringMVC支持XML配置方式和注解方式
 * xml配置：控制层必须实现Controller接口，实现handleRequest方法
 */
public class HelloSpringMvc implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(this.getClass().getName());
        //创建ModelAndView对象
        ModelAndView mav=new ModelAndView();
        //添加视图名称，即：要跳转的页面的名称
        mav.setViewName("hello");
        //向前端页面添加的属性值
        mav.addObject("para", "Hello SpringMvc");
        return mav;
    }
}
