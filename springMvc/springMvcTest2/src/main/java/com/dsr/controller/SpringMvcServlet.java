package com.dsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class SpringMvcServlet {
    @RequestMapping(value = "/servletApi")
    public String hello(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        //request操作
        String agent=request.getHeader("USER-AGENT");
        System.out.println(agent);
        Cookie[] cookies=request.getCookies();
        System.out.println(cookies.length+",name="+cookies[0].getName()+",value="+cookies[0].getValue()+
                ",path="+cookies[0].getPath()+",comment="+cookies[0].getComment());
        String name = request.getParameter("id");
        System.out.println(name);
        //sessiion操作
        System.out.println("session----------");
        String id = session.getId();
        System.out.println(id);
        Enumeration<String> attributeNames = session.getAttributeNames();
        System.out.println("cookie---------");
        Cookie[] cookies1 = request.getCookies();
        for(Cookie cookie:cookies1){
            System.out.println("name="+cookie.getName()+",value="+cookie.getValue());
        }
        //request.setAttribute("name", "servlet To jsp");
        session.setAttribute("name", "session to Jsp");
        request.getRequestDispatcher("/test").forward(request, response);
        response.sendRedirect("/test");
        return "success";
    }
    @RequestMapping(value = "/servletApi2",method = RequestMethod.GET,params = {"id=段盛荣"})
    public String hello3(String id){
        System.out.println(id);
        return "success";
    }
}
