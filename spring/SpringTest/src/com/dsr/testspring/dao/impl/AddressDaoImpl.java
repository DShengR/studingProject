package com.dsr.testspring.dao.impl;

import com.dsr.testspring.bean.Address;
import com.dsr.testspring.bean.Person;
import com.dsr.testspring.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 目标类
 */
@Repository
public class AddressDaoImpl implements BaseDao {
    @Override
    public void insert(String sqlId, Map<String, Object> para) {
        System.out.println("Address insert");
    }

    @Override
    public void delete(String sqlId, Map<String, Object> para) {
        System.out.println("Address delete");
    }

    @Override
    public void update(String sqlId, Map<String, Object> para) {
        System.out.println("Address update");
    }

    @Override
    public List query(String sqlId, Map<String, Object> para) {
        System.out.println("Address query");
        List list=new ArrayList();
        list.add(new Address("1","中国","甘肃"));
        return list;
    }
}
