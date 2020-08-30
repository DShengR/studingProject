package com.dsr.controller;

import com.dsr.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class ModelAttributeController {
    @ModelAttribute
    public void modelAttr1(Model model){
        System.out.println("modelAttribute1------");
        model.addAttribute("myName", "duan sheng rong");
    }
    @RequestMapping("/helloModelAttr")
    public String helloModelAttr(Model model){
        System.out.println(model.getAttribute("myName"));
        return "success";
    }

    @ModelAttribute
    public void modelAttr2(Model model){
        System.out.println("modelAttr2------");
        User user=new User();
        user.setName("段盛荣");
        user.setAge(12);
        user.setGender("男");
        model.addAttribute("user", user);
    }
    @RequestMapping("/helloModelAttr2")
    public String  helloModelAttr2( @ModelAttribute("u") User user1){
        System.out.println(user1.toString());
       return "success";
    }
    @ModelAttribute("u")
    public User modelAttr3(){
        System.out.println("modelAttr3------");
        User user=new User();
        user.setName("段盛荣");
        user.setAge(12);
        user.setGender("男");
        return user;
    }
}
