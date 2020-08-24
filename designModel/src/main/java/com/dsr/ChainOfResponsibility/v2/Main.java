package com.dsr.ChainOfResponsibility.v2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String msg="Hello <_> ,I am dsr ,we are 996";
        Request request=new Request();
        Response response=new Response();
        request.setMsg(msg);
        FilterChain chain=new FilterChain();
        //chain.addFilter(new FaceFilter()).addFilter(new SensitiveFilter());
        FilterChain chain2=new FilterChain();
        chain2.addFilter(new SensitiveFilter());
        chain.addFilter(chain2);
        chain.addFilter(new FaceFilter());
        chain.doFilter(request,response);
        System.out.println(request.getMsg());
    }
}
class FilterChain implements Filter {
    LinkedList<Filter> filters=new LinkedList<>();
    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Response response) {
        for(Filter filter:filters){
            if(!filter.doFilter(request,response)) return false;
        }
        return true;
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
interface  Filter{
    boolean doFilter(Request request, Response response);
}
class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.setMsg(request.getMsg().replaceAll("<_>","^_^"));
        return true;
    }
}
class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.setMsg(request.getMsg().replaceAll("996", "955"));
        return true;
    }
}
