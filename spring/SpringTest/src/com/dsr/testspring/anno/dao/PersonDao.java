package com.dsr.testspring.anno.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    public void save(){
        System.out.println("insert ....");
    }
}
