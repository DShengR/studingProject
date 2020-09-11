package com.dsr.testspring.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    private String name;
    private int age;
    private String sex;
    private String telNo;
    private String[] hobbies;
    private Address address;
    private List<Address> lists;
    private Set<Address> sets;
    private Map<String,Address> maps;

    public Person() {
    }

    public Person(String name, int age, String sex, String telNo) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNo = telNo;
    }
    public void init(){

    }
    public void destory(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress1(Address addres) {
        this.address = addres;
    }

    public List<Address> getLists() {
        return lists;
    }

    public void setLists(List<Address> lists) {
        this.lists = lists;
    }

    public Set<Address> getSets() {
        return sets;
    }

    public void setSets(Set<Address> sets) {
        this.sets = sets;
    }

    public Map<String, Address> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Address> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telNo='" + telNo + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", addres=" + address +
                ", lists=" + lists +
                ", sets=" + sets +
                ", maps=" + maps +
                '}';
    }
}
