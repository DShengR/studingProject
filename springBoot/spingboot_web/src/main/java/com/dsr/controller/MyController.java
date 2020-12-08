package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MyController {
    @RequestMapping("/bootController")
    public String bootController(ModelMap map, HttpSession session){
        System.out.println(map.get("name"));
        System.out.println(session);
        return "ddddd";
    }
}
