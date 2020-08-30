package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMvcForwardController {
    @RequestMapping("/forward1")
    public String forward1(){
        return "forward:/WEB-INF/page/success.jsp";
    }
    @RequestMapping("/forward2")
    public String forward2(){
        return "forward:/forward1";
    }
}
