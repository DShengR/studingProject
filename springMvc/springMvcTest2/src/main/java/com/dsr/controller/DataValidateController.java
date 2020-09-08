package com.dsr.controller;

import com.dsr.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.tags.BindErrorsTag;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataValidateController {
    @RequestMapping("/dataValidate")
    public String dataValidate(@Valid User user,BindingResult result, Model model){
        System.out.println(user);
        if(result.hasErrors()){
            System.out.println("数据校验失败");
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String,Object> errMap= new HashMap<>();
            for(FieldError error:fieldErrors){
                errMap.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("err", errMap);
            return "forward:/index.jsp";
        }
        return "success";
    }
}
