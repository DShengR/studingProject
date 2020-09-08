package com.dsr.controller;

import com.dsr.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ResponseBody：将当前请求返回的内容作为响应体
 */
@Controller
public class JsonController {
    @ResponseBody
    @RequestMapping("/json")
    public List<User> helloJson(){
        List<User> list=new ArrayList<User>();
        list.add(new User("duansr",22,"男1","ddd163",new Date()));
        list.add(new User("zhangsan",26,"男","ddd16",new Date()));
        list.add(new User("lili",22,"女","aaa@163.com",new Date()));
        return list;
    }
    @ResponseBody
    @RequestMapping("/json1")
    public String  helloJson1(){
        System.out.println("json1---before");
        System.out.println("json1---return");
        return "<h1>Hello SpringMvc</h1>";
    }
    @RequestMapping("/requestBody")
    public String helloRequestBody(@RequestBody String bodyStr){
        System.out.println(bodyStr);
        return "success";
    }
}
