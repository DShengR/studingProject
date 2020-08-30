package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMvcRedirectController {
    @RequestMapping(value = "redirect1")
    public String redirect1(){
        return "redirect:/index.jsp";
    }
    @RequestMapping(value = "redirect2")
    public String redirect2(){
        return "redirect:/forward1";
    }
}
