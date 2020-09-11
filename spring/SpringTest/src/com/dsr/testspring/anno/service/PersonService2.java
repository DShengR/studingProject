package com.dsr.testspring.anno.service;

import com.dsr.testspring.anno.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service(value = "personSer")

public class PersonService2 implements Service {
    @Autowired
    private PersonDao dao;
    @Override
    public void service() {
        System.out.println("personService2..");
    }
}
