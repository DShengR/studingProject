package com.dsr.springboot_data.controller;

import com.dsr.springboot_data.bean.Emp;
import com.dsr.springboot_data.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    EmpMapper mapper;

    @RequestMapping("/getEmp")
    public Emp getEmp(String id) {
        Emp empById = mapper.getEmpById(Integer.parseInt(id));
        List<Emp> list = new ArrayList<>();
        System.out.println(id);
        list.add(empById);
        return empById;
    }
}
