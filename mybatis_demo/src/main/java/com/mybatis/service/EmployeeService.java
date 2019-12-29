package com.mybatis.service;

import com.mybatis.model.Emp;
import com.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Brian in 13:36 2018/4/5
 */

@Service
public class EmployeeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;

    public List<Emp> getEmps() {
        return employeeMapper.getEmps();

    }

    public Emp getbyEmpno(Emp emp) {

        System.out.println("jdbcTemplate == " + jdbcTemplate);

        return employeeMapper.getbyEmpno(emp);
    }
}
