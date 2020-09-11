package com.dsr.testspring.proxy;

import com.dsr.testspring.aspect.LogUtil;
import com.dsr.testspring.dao.BaseDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyProxy {
    public static Object getProxy(final BaseDao dao){
        ClassLoader loader= dao.getClass().getClassLoader();
        Class<?>[] interfaces = dao.getClass().getInterfaces();
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {

                Object result = null;
                try {
                   // LogUtil.start();
                    result = method.invoke(dao, args);
                   // LogUtil.stop();
                } catch (IllegalAccessException e) {
                    //LogUtil.exception();
                } catch (InvocationTargetException e) {
                    //LogUtil.exception();
                }finally {
                    //LogUtil.finall();
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;
    }
}
