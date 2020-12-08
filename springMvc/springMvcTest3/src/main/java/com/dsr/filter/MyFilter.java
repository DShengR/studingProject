package com.dsr.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
@Override
public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass()+"----init");
        }

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(this.getClass()+"----doFilter-before");
        String name = servletRequest.getParameter("name");
        servletRequest.getServletContext();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(this.getClass()+"----doFilter-after");
        }

@Override
public void destroy() {
        System.out.println(this.getClass()+"----destroy");
        }
        }
