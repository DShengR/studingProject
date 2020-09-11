package com.dsr.testspring.dao.impl;

import com.dsr.testspring.bean.Person;
import com.dsr.testspring.dao.BaseDao;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 目标类
 */
@Repository
public class PersonDaoImpl  {
    public int insert(String sqlId, Map<String, Object> para) {
        System.out.println("Person insert");
        return 0;
    }


    public void delete(String sqlId, Map<String, Object> para) {
        para.size();
        System.out.println("Person delete");
    }


    public void update(String sqlId, Map<String, Object> para) {
        System.out.println("Person update");
    }


    public List query(String sqlId, Map<String, Object> para) {
        System.out.println("Person query");
        List list=new ArrayList();
        list.add(new Person("dsr",25,"男","132999999999"));
        return list;
    }
}
