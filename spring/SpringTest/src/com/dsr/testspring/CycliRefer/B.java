package com.dsr.testspring.CycliRefer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    private C c;




    public C getC() {
        return c;
    }

    @Override
    public String toString() {
        return "B{" +
                "c=" + c +
                '}';
    }
}
