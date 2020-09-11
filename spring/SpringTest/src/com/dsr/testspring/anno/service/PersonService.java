package com.dsr.testspring.anno.service;

import com.dsr.testspring.anno.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class PersonService implements com.dsr.testspring.anno.service.Service {
    @Autowired
    private PersonDao dao;
    @Override
    public void service(){
        System.out.println("personService..");
        dao.save();
    }
}
