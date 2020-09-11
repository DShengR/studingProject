package com.dsr.testspring.factory;

import com.dsr.testspring.bean.Person;

public class PersonStaticFactory {
    public static Person getInstance(){
        Person person=new Person();
        person.setName("static factory");
        return person;
    }
}
