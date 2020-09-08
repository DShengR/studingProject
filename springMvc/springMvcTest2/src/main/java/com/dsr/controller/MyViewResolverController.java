package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyViewResolverController {
    @RequestMapping(value = "/viewResolver")
    public String helloViewResolver(){
        return "dsr:success";
    }
}
