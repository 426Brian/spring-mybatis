package com.mybatis.dao;

import com.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Brian in 15:16 2018/4/4
 */
public interface EmployeeDynamicSql {
    List<Emp> getEmpIf(Emp emp);
    List<Emp> getEmpChoose(Emp e);
    void setEmp(Emp emp);

    List<Emp> selectForeach(@Param("empnos") List<Short> list);
    void insertBatch(@Param("emps") List<Emp> list);

    List<Emp> comsqlTest();

    Emp empbyNo(Emp emp);
}
