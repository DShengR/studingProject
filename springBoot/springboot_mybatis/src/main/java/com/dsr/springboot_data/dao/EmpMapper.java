package com.dsr.springboot_data.dao;

import com.dsr.springboot_data.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface EmpMapper {
    @Select("select * from emp where empno=#{id}")
    public Emp getEmpById(Integer id);
}
