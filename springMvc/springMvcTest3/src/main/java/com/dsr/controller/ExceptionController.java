package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    @RequestMapping("/exce1")
    public String exce1(){
        int i=10/0;
        return "success";
    }
    @RequestMapping("/exce2")
    public String exce2(){
        String s=null;
        s.length();
        return "success";
    }
    @RequestMapping("/exce3")
    public String exce3(){
        String[] s=new String[]{"1"};
        String str=s[1];
        return "success";
    }
    @RequestMapping("/exce4")
    public String exce4(){
        return "success";
    }
    @ExceptionHandler(value = {NullPointerException.class,ArithmeticException.class})
    public ModelAndView handleExce1(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("error");
        mav.addObject("exce", e);
        return mav;
    }
/*    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleExce2(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("error");
        mav.addObject("exce", "all-exception----"+e);
        return mav;
    }*/
    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName",required = false) String userName){
        if(!"dsr".equals(userName))
            throw new IlegalUserNameException();
        return "success";
    }
}
