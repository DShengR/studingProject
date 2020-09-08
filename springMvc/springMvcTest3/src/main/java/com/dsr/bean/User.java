package com.dsr.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import java.util.Date;

public class User {
    //必须为空
    @Null
    private String name;
    //不能为空
    @NotNull
    private Integer age;
    //长度范围1-1
    @Length(min=1,max = 1)
    private String gender;
    //email格式
    @Email
    private String email;
    //过去的时间
    @Past
    @DateTimeFormat(pattern = "yyyyMMdd")//Sun Jan 01 00:10:00 CST 1995  Sun Oct 01 00:00:00 CST 1995
    private Date birth;

    public User() {
    }

    public User(String name, Integer age, String gender, String email, Date birth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
