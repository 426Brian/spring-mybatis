package com.mybatis.dao;

import com.mybatis.model.Emp;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Brian in 11:30 2018/4/5
 */

public interface EmployeeMapper {
    Emp getbyEmpno(Emp emp);

    List<Emp> getEmps();
}
