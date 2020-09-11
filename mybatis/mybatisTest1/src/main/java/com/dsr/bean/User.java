package com.dsr.bean;

public class User {
    private Integer id;
    private String name;
    private String sex;
    private String age;

    public User(Integer id, String name, String sex, String aage) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = aage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAAge(String aage) {
        this.age = aage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
