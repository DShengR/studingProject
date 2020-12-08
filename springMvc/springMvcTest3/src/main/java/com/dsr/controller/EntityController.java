package com.dsr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Map;

@Controller
public class EntityController {
    private int age;
    @RequestMapping("/httpEntity")
    public String httpEntity(HttpEntity<Object> httpEntity){
        Object body = httpEntity.getBody();
        HttpHeaders headers = httpEntity.getHeaders();
        System.out.println("body-----"+body);
        System.out.println("headers----"+headers.get("accept"));
        return "success";
    }
}
