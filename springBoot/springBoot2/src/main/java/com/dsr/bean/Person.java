package com.dsr.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    // @Value("${person.name}")
    private String lastName;
    // @Value("${person.sex}")
    private String sex;
    // @Value("${person.age}")
    private Integer age;
    //  @Value("${person.likes}")
    private List<String> likes;

    public Person() {
    }

    public Person(String name, String sex, Integer age, List<String> list) {
        this.lastName = name;
        this.age = age;
        this.sex = sex;
        this.likes = list;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", likes=" + likes +
                '}';
    }
}
