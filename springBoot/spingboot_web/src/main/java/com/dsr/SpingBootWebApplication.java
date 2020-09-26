package com.dsr;

import com.dsr.filter.MyFilter;
import com.dsr.listener.MyListener;
import com.dsr.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.dsr")
public class SpingBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootWebApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
		ServletRegistrationBean<MyServlet> bean=new ServletRegistrationBean<>();
		bean.setServlet(new MyServlet());
		bean.setLoadOnStartup(1);
		ArrayList list=new ArrayList();
		list.add("/servlet");
		bean.setUrlMappings(list);
		return bean;
	}
	@Bean
	public FilterRegistrationBean<MyFilter> getFilterRegistrationBean(){
		FilterRegistrationBean<MyFilter> bean=new FilterRegistrationBean<>();
		bean.setFilter(new MyFilter());
		bean.setOrder(1);
		bean.addUrlPatterns("/*");
		bean.addInitParameter("initParameter","初始化参数");
		return bean;
	}

	@Bean
	public ServletListenerRegistrationBean<MyListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<MyListener> bean=new ServletListenerRegistrationBean<>();
		bean.setListener(new MyListener());
		bean.setOrder(1);
		return bean;
	}
}
