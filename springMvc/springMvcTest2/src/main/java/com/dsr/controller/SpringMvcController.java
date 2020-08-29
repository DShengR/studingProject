package com.dsr.controller;

import com.dsr.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpringMvcController {
    @RequestMapping("/helloParam")
    /**
     * @RequestParam
     *  value:参数的名称必须与请求的参数名一致
     *  required:参数是否必输，默认是要必输的,不输的话返回400响应
     *  defaultVaule:设置默认值，当上送的参数为空时使用默认值，不为空时使用上送的
     */
    public String hello(@RequestParam(value = "name",required = false,defaultValue = "段盛荣-dsr") String userName){
        System.out.println(userName);
        return "success";
    }

    @RequestMapping("/helloHeader")
    /**
     * request.getHeader("USER-AGENT");
     * 在SpringMVC中不能直接使用方法参数的方式来获取头里面的值
     * 使用@RequestHeader注解来获取头数据
     * @RequesHeader
     *  value:参数的名称必须与请求的参数名一致
     *  required:参数是否必输，默认是要必输的，不输的话返回400响应(如果设置了defaultValue，则使用默认值不会返回400)
     *  defaultVaule:设置默认值，当上送的参数为空时使用默认值，不为空时使用上送的
     */
    public String helloHeader(@RequestHeader(value = "Accept1",required = true,defaultValue = "default value ") String Accept){
        System.out.println(Accept);
        return "success";
    }

    @RequestMapping("/helloCookie")
    /**
     * 在servlet中使用 Cookie[] cookies = request.getCookies();
     * for(Cookie cookie:cookies){
     *     cookie.getName();
     *     cookie.getValue();
     * }
     * 在SpringMVC中不能直接使用方法参数的方式来获取Cookie的值
     * 使用@RequestCookie注解来获取Cookie的值
     * @RequesHeader
     *  value:参数的名称必须与请求的参数名一致
     *  required:参数是否必输，默认是要必输的，不输的话返回400响应(如果设置了defaultValue，则使用默认值不会返回400)
     *  defaultVaule:设置默认值，当上送的参数为空时使用默认值，不为空时使用上送的
     */
    public String helloCookie(@CookieValue(value = "JSESSIONID1",required = false,defaultValue = "123456") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/helloObject")
    public String helloObject(User user){
        System.out.println(user.toString());
        return "success";
    }
}
