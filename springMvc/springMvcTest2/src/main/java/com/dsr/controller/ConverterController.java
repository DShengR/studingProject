package com.dsr.controller;

import com.dsr.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConverterController {
    @RequestMapping("/converter")
    public String converter(User user){
        System.out.println("myconverter--"+user);
        return "success";
    }
}
