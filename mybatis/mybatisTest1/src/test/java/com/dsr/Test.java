package com.dsr;

import com.dsr.bean.User;
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
    }
}
