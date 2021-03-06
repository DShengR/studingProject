package com.dsr.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener  implements ServletRequestListener {
    public static int totalRequest=0;//总共请求次数
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request创建："+sre.getServletRequest());
        totalRequest++;
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request销毁："+sre.getServletRequest());
    }
}
