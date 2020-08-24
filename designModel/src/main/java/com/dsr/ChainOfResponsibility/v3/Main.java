package com.dsr.ChainOfResponsibility.v3;

import java.util.LinkedList;

/**
 * Created by duansr on 2020/8/24.
 * 增加过滤器处理response
 */
public class Main {
    public static void main(String[] args) {
        String msg="Hello <_> ,I am dsr ,we are 996";
        Request request=new Request();
        Response response=new Response();
        request.setMsg(msg);
        FilterChain chain=new FilterChain();
        FilterChain chain2=new FilterChain();
        chain2.addFilter(new SensitiveFilter());
        chain.addFilter(chain2);
        chain.addFilter(new FaceFilter());
        chain.doFilter(request,response);
        System.out.println(request.getMsg());
    }
}
class FilterChain  extends  Filter{
    private int index=0;
    private LinkedList<Filter> filters=new LinkedList<>();
    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        return false;
    }
    @Override
    public boolean doFilter(Request request, Response response) {
        /*for(Filter filter:filters){
            if(!filter.doFilter(request,response)) return false;
        }*/
        if(!(index>=filters.size())) {
            Filter filter = filters.get(index++);
            filter.doFilter(request, response, this);
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
abstract class  Filter{
    abstract  boolean doFilter(Request request, Response response,FilterChain chain);
    public boolean doFilter(Request request,Response response){

        return true;
    }
}
class FaceFilter extends Filter {
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        System.out.println("request---facefilter");
        request.setMsg(request.getMsg().replaceAll("<_>","^_^"));
        chain.doFilter(request,response);
        System.out.println("response---facefilter");
        return true;
    }
}
class SensitiveFilter extends Filter {
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        System.out.println("request---sensitivefilter");
        request.setMsg(request.getMsg().replaceAll("996", "955"));
        chain.doFilter(request,response);
        System.out.println("response---sensitivefilter");
        return true;
    }
}
