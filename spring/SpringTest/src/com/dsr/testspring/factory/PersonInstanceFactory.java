package com.dsr.testspring.factory;

import com.dsr.testspring.bean.Person;

public class PersonInstanceFactory {
    public Person getInstance(){
        Person person=new Person();
        person.setName("instance factory");
        return person;
    }
}
