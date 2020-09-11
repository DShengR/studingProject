package com.dsr.dao;

import com.dsr.bean.Dept;

public interface DeptDao {
    public Dept getDeptById(Integer id);
    //分步插叙
    public Dept getDeptByStep(Dept dept);
}
