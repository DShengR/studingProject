package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by duansr on 2020/8/27.
 * 使用注解方式配置，不用实现Controller接口，方法名称可以自定义
 */
@Controller
//@RequestMapping(value="/dsr")
public class HelloSpringMvcAnno {
    /**
     *RequestMapping注解，用来配置请求路径和处理请求的方法的映射，用value属性配置请求的路径，"/"可写可不写，建议写
     * RequestMapping可以添加在方法上也可以添加在类上，添加在类上表示给此类的所有方法加一个父访问路径，即：比加在方法上多了一级访问路径
     *      当有多个controll并且多个controller中有同名的访问路径时需要在类上添加RequestMapping注解
     *
     * RequestMapping的其他配置参数
     *  value：表示要匹配的请求
     *  method：表示请求的方法：post,get...
     *  params：必须要包含的参数,params={"hi"}
     *          不能包含的参数,params={"!h"}
     *          指定参数值，params={"hi=1111"}
     *  headers：表示限制请求头中相关的属性，用来做请求的限制 headers={""}
     *  consumes：限制响应中的Content-type
     *  produces：限制请求中的Content-type
     *
     *  RequestMapping支持模糊匹配
     *      ?：匹配单个字符
     *      *：匹配多个字符
     *      **：匹配多层路径
     *      如果能匹配到多个请求，那么优先精准匹配
     */
    @RequestMapping(value="helloAnno" ,method = RequestMethod.GET ,params ={"hi","!h","name=dsr"})
    public String hello(Map<String,Object> para,String name,String hi){
        System.out.println(this.getClass().getName());
        System.out.println(hi);
        System.out.println(name);
        para.put("para","Hello SpringMVC-anno");
        return "hello";
    }

    @RequestMapping(value="helloPathVar/{name1}/{hi}/{who}" ,method = RequestMethod.GET )
    public String helloPathVar(Map<String,Object> para,@PathVariable String name1,@PathVariable(value="hi") String id
            ,@PathVariable(name="who") String i,@PathVariable String alloNull){
        System.out.println(this.getClass().getName());
        System.out.println("id:"+id);
        System.out.println("name:"+name1);
        System.out.println("who:"+i);
        System.out.println("alloNull:"+alloNull);
        para.put("para","Hello SpringMVC-PathVariable");
        return "hello";
    }
}
