package com.dsr;

import com.dsr.bean.Dept;
import com.dsr.bean.Dog;
import com.dsr.bean.Emp;
import com.dsr.dao.DeptDao;
import com.dsr.dao.DogDao;
import com.dsr.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    SqlSessionFactory build=null;
    @Before
    public void init() throws IOException {
        String source="mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(source);
        build = new SqlSessionFactoryBuilder().build(in);
    }
    @org.junit.Test
    public void test1(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpById2("emp",7934);
        System.out.println(emp);
    }
    @org.junit.Test
    public void test2(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpByIdAndSal(7499, 1600.0);
        System.out.println(emp);
    }
    @org.junit.Test
    public void test3(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Map map=new HashMap<String,Object>();
        map.put("empno", 7499);
        map.put("sal", 1600.0);
        Emp emp = mapper.getEmpByMap(map);
        System.out.println(emp);
    }

    @org.junit.Test
    public void test4(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        List<Emp> allEmps = mapper.getAllEmps();
        System.out.println(allEmps);
    }

    @org.junit.Test
    public void test5(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp=new Emp();
        emp.setEmpno(7499);
        Map<String, Object> empMap = mapper.getEmpMapById(emp);
        System.out.println(empMap);
    }

    @org.junit.Test
    public void test6(){
        SqlSession session = build.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp=new Emp();
        emp.setEmpno(7499);
        Map<Integer, Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);
    }

    @org.junit.Test
    public void test7(){
        SqlSession session=build.openSession();
        DogDao mapper = session.getMapper(DogDao.class);
        Dog dog = mapper.getDogById(1);
        System.out.println(dog);
    }

    @org.junit.Test
    public void test8(){
        SqlSession session=build.openSession();
        EmpDao empDao = session.getMapper(EmpDao.class);
        Emp emp = empDao.getEmpAndDept(7499);
        System.out.println(emp.getEmpno());
    }

    @org.junit.Test
    public void test9(){
        SqlSession session=build.openSession();
        DeptDao deptDao = session.getMapper(DeptDao.class);
        Dept dept = deptDao.getDeptById(30);
        System.out.println(dept);
    }

    //分步查询
    @org.junit.Test
    public void test10(){
        SqlSession session=build.openSession();
        EmpDao empDao = session.getMapper(EmpDao.class);
        Emp emp=new Emp();
        emp.setEmpno(7499);
        Emp emp1 = empDao.getEmpBySetp(emp);
        System.out.println(emp1);
    }
    //分步查询
    @org.junit.Test
    public void test11(){
        SqlSession session=build.openSession();
        DeptDao deptDao = session.getMapper(DeptDao.class);
        Dept dept=new Dept();
        dept.setDeptno(30);
        Dept dept1 = deptDao.getDeptByStep(dept);
        System.out.println(dept1.getDeptno());
        System.out.println("-------------------");
        //System.out.println(dept1.getEmps().get(0));
    }
}
