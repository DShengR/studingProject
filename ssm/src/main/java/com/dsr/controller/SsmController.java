package com.dsr.controller;

import com.dsr.bean.Dept;
import com.dsr.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SsmController {
    @Autowired
    private DeptDao deptDao;
    @RequestMapping("/ssm")
    public String helloSSM(Model model){
        Dept dept=new Dept();
        dept.setDeptno(10);
        dept=deptDao.getDeptById(dept);
        model.addAttribute("dept",dept);
        return "success";
    }
}
