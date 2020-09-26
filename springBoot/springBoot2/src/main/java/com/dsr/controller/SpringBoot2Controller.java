package com.dsr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBoot2Controller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springBoot by idea";
    }
}
