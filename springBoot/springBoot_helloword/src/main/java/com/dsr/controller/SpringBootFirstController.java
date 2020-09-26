package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootFirstController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}
