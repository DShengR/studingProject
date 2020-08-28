package com.dsr.controller;

import com.dsr.dao.RestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by duansr on 2020/8/28.
 */
@Controller
public class RestController {
    @Autowired
    private RestDao restDao;

    @RequestMapping(value = "/helloRest",method = RequestMethod.PUT)
    public String update(){
        restDao.update();
        return "success";
    }
    @RequestMapping(value = "/helloRest",method = RequestMethod.POST)
    public String insert(){
        restDao.insert();
        return "success";
    }
    @RequestMapping(value = "/helloRest",method = RequestMethod.DELETE)
    public String delete(){
        restDao.delete();
        return "success";
    }
    @RequestMapping(value = "/helloRest",method = RequestMethod.GET)
    public String query(){
        restDao.query();
        return "success";
    }
}
