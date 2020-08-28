package com.dsr.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by duansr on 2020/8/28.
 */
@Repository
public class RestDao {
    public void insert() {System.out.println("insert---");}
    public void delete() {
        System.out.println("delete---");
    }
    public void update(){
        System.out.println("update---");
    }
    public void query(){
        System.out.println("query---");
    }
}