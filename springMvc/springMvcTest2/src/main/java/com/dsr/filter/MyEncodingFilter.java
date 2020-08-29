package com.dsr.filter;

import javax.servlet.*;
import java.io.IOException;
public class MyEncodingFilter implements Filter {
    private String encoding="UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyEncodingFilter init...");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(encoding!=null){
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("MyEncodingFilter destory...");
    }
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
