package com.dsr;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;

import java.util.List;
import java.util.Properties;

public class MyObjectFactory implements ObjectFactory {
    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public <T> T create(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T create(Class<T> aClass, List<Class<?>> list, List<Object> list1) {
        return null;
    }

    @Override
    public <T> boolean isCollection(Class<T> aClass) {
        return false;
    }
}
