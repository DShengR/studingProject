package com.dsr.converter;

import com.dsr.bean.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MyConverter implements Converter<String,User> {
    @Override
    //source:name-age-gender
    public User convert(String source) {
        System.out.println("convert----------------");
        String[] arrs=source.split("-");
        User user= new User();
        user.setName(arrs[0]);
        user.setAge(Integer.parseInt(arrs[1]));
        user.setGender(arrs[2]);
        return user;
    }
}
