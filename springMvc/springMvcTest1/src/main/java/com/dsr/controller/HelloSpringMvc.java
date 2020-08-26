package com.dsr.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloSpringMvc implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(this.getClass().getName());
        ModelAndView mav=new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("para", "Hello SpringMvc");
        return mav;
    }
}
