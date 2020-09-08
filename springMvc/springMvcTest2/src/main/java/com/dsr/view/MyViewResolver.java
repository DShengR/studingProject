package com.dsr.view;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 自定义视图解析器，需要实现ViewResolver接口，实现resolveViewName方法
 * 在DispatcherServlet中维护着一个List，来存放视图解析器，当有多个视图解析器时会根据order属性排序，来规定遍历时的顺序
 * order值越小越排在前面,规定order的值可以用@Order注解或者用setOrder方法
 */
@Component
@Order(1)
public class MyViewResolver implements ViewResolver, Ordered {
    private int order;
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if(viewName!=null){
            if(viewName.startsWith("dsr:")){
                return new MyView();
            }
        }
        return null;
    }
    @Override
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order){
        this.order=order;
    }
}
