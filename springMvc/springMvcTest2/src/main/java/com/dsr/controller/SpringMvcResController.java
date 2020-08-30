package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Controller
//@SessionAttributes(types = String.class)
@SessionAttributes(value = {"test"})
public class SpringMvcResController {
    @RequestMapping(value = "/resHandle1")
    public String resControl1(Map map, @RequestParam(value = "type") String name){
        map.put("name", name);
        return "success";
    }
    @RequestMapping(value = "/resHandle2")
    public String resControl2(ModelMap modelMap, @RequestParam(value = "type") String name){
        modelMap.addAttribute("name",name);
        return "success";
    }
    @RequestMapping(value = "/resHandle3")
    public String resControl3(Model model, @RequestParam(value = "type") String name){
        model.addAttribute("name",name);
        return "success";
    }
    @RequestMapping(value = "/resHandle4")
    public ModelAndView resControl4(@RequestParam(value = "type") String name){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("success");
        mv.addObject("name", name);
        return mv;
    }
    @RequestMapping(value = "/resBySession")
    public String helloSession(Model model,@RequestParam(value = "type",defaultValue = "model_default") String name){
        model.addAttribute("type",name);
        model.addAttribute("name","dsr");
        return "success";
    }
    @RequestMapping(value = "/resBySession1")
    //通过@SessionAttributes获取session的值
    public String testSession(@SessionAttribute(value = "name") String name){
        System.out.println(name);
        return "success";
    }
}
