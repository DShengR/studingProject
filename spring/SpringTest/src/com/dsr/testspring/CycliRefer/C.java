package com.dsr.testspring.CycliRefer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class C {
    @Autowired
    private A a;

    public A getA() {
        return a;
    }

}
