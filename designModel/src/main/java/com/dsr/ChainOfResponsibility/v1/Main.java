package com.dsr.ChainOfResponsibility.v1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String msg="Hello <_> ,I am dsr ,we are 996";
        Request request=new Request();
        Response response=new Response();
        request.setMsg(msg);
        new FaceFilter().doFilter(request,response);
        new SensitiveFilter().doFilter(request,response);
        System.out.println(request.getMsg());
    }
}

class Request{
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
class Response{
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class FaceFilter {
    public void doFilter(Request request, Response response) {
        request.setMsg(request.getMsg().replaceAll("<_>","^_^"));
    }
}
class SensitiveFilter {
    public void doFilter(Request request, Response response) {
        request.setMsg(request.getMsg().replaceAll("996", "955"));
    }
}
