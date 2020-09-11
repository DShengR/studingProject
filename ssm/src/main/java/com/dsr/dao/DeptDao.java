package com.dsr.dao;

import com.dsr.bean.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptDao {
    public Dept getDeptById(Dept dept);
    public Dept getDeptById2(Dept dept);
    public List<Dept> selectDeptById3(@Param("deptnos") List<Integer> deptnos);
    public List<Dept> selectDeptById4(Dept dept);

    public int saveDept(Dept dept);
    public int updateDept(Dept dept);

}
