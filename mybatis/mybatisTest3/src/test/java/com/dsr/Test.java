package com.dsr;

import com.dsr.bean.Dept;
import com.dsr.dao.DeptDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
        String resource="mybatis-config.xml";
        Reader reader= Resources.getResourceAsReader(resource);
        factory=new SqlSessionFactoryBuilder().build(reader);
    }
    @org.junit.Test
    public void test1(){
        SqlSession session = factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
        //dept.setDeptno(30);
        dept.setDname("SALES");
        Dept dept1 = mapper.getDeptById(dept);
        System.out.println(dept1);
    }

    //trim定制where
    @org.junit.Test
    public void test2(){
        SqlSession session = factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
//        dept.setDeptno(30);
//        dept.setDname("SALES");
        Dept dept1 = mapper.getDeptById2(dept);
        System.out.println(dept1);
    }

    //foreach
    @org.junit.Test
    public void test3(){
        SqlSession session = factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
        //dept.setDeptno(30);
        //dept.setDname("SALES");
        dept.setLoc("NEW YORK");
        List<Dept> depts = mapper.selectDeptById4(dept);
        System.out.println(depts);
    }

    //choose
    @org.junit.Test
    public void test4(){
        SqlSession session = factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        List<Dept> depts = mapper.selectDeptById3(list);
        System.out.println(depts);
    }


    //缓存
    @org.junit.Test
    public void test5(){
        SqlSession session=factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
        dept.setDeptno(30);
        Dept dept1 = mapper.getDeptById(dept);
        System.out.println(dept1);
        System.out.println("------------------");
        Dept dept2 = session.getMapper(DeptDao.class).getDeptById(dept);
        System.out.println(dept2);
        dept.setDeptno(40);
        System.out.println("------------------");
        Dept dept3 = session.getMapper(DeptDao.class).getDeptById(dept);
        System.out.println(dept3);
    }
    //缓存失效场景
    @org.junit.Test
    public void test6(){
        SqlSession session=factory.openSession();
        SqlSession session1=factory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
        dept.setDeptno(30);
        Dept dept1 = mapper.getDeptById(dept);
        System.out.println(dept1);
        System.out.println("-----第二次查-------------");
        dept.setDeptno(40);
        Dept dept2 = session.getMapper(DeptDao.class).getDeptById(dept);
        System.out.println(dept2);
        System.out.println("-----第一次插入-------------");
        dept.setDeptno(50);
        dept.setDname("dev");
        dept.setLoc("shang hai");
        int i = session1.getMapper(DeptDao.class).saveDept(dept);
        System.out.println(i);
        System.out.println("-----第三次查-------------");
        Dept dept3=new Dept();
        dept3.setDeptno(30);
        Dept dept4 = session.getMapper(DeptDao.class).getDeptById(dept3);
        System.out.println(dept4);
        session.clearCache();
    }
}
