package com.dsr.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns={"/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init...");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter--before:"+request+","+response);
        chain.doFilter(request, response);
        System.out.println("doFilter--after:"+request+","+response);
    }
    @Override
    public void destroy() {
        System.out.println("MyFilter destroy...");
    }
}
