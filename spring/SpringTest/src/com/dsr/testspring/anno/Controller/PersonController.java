package com.dsr.testspring.anno.Controller;

import com.dsr.testspring.anno.dao.PersonDao;
import com.dsr.testspring.anno.service.PersonService;
import com.dsr.testspring.anno.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;

@Controller(value = "personController1")
@Scope(value = "singleton")
public class PersonController {
    private String role;
    @Resource()
   // @Autowired
    @Qualifier(value = "personSer")
    public Service personService2;
    @Resource(name = "")
    private PersonDao dao;

    public void control(){
        personService2.service();
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PersonController{" +
                "role='" + role + '\'' +
                '}';
    }
}
