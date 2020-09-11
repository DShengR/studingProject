package com.dsr.dao;

import com.dsr.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    public Emp getEmpById(Integer id);
    public Emp getEmpById2(String tableName,Integer id);
    public Emp getEmpByIdAndSal(@Param("empno")Integer id,@Param("sal") Double sal);
    public Emp getEmpByMap(Map param);
    public List<Emp> getAllEmps();
    public Map<String,Object> getEmpMapById(Emp emp);
    //@MapKey("empno")
    public Map<Integer,Emp> getAllEmp();
    //联合查询
    public  Emp getEmpAndDept(Integer empno);
    //分步查询
    public Emp getEmpBySetp(Emp emp);
    public List<Emp> getEmpBydeptNo(Integer deptno);
}
