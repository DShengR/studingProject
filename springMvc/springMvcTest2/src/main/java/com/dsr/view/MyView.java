package com.dsr.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class MyView implements View {
    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=ISO-8859-1";
    @Override
    public String getContentType() {
        return DEFAULT_CONTENT_TYPE;
    }
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("myView---model:"+model);
        PrintWriter writer = response.getWriter();
        writer.write("hello i am myview");
        writer.write("自定义view");
    }
}
