package com.dsr;

import com.dsr.bean.User;
import com.dsr.dao.NoMapperDao;
import com.dsr.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    private SqlSessionFactory build;
    @Before
    public void init() throws IOException {
        String resource="mybatis-config.xml";
        InputStream in= Resources.getResourceAsStream(resource);
        build = new SqlSessionFactoryBuilder().build(in);
    }
    @org.junit.Test
    public void test01(){
        SqlSession session = build.openSession();
        System.out.println(session);
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        session.close();
    }

    @org.junit.Test
    public void test02(){
        SqlSession session = build.openSession();
        System.out.println(session);
        NoMapperDao mapper = session.getMapper(NoMapperDao.class);
        //User user = mapper.getUserById(2);
        //System.out.println(user);
    }

    @org.junit.Test
    public void test03(){
        SqlSession session = build.openSession();
        System.out.println(session);
        UserDao mapper = session.getMapper(UserDao.class);
        User user=new User();
        user.setName("test");
        user.setAge(22);
        user.setSex("男");

        int i= mapper.saveUser(user);
        System.out.println(i+"---"+user);
        session.commit();
        session.close();

    }
}
