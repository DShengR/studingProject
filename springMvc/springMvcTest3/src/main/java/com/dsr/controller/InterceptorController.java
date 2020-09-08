package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {
    @RequestMapping("/inter")
    public String testInterceptor(){
        System.out.println(this.getClass()+"----testInterceptor");
        return "success";
    }
}
