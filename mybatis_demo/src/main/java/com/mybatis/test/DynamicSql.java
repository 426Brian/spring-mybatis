package com.mybatis.test;

import com.mybatis.dao.EmployeeDynamicSql;
import com.mybatis.model.Dept;
import com.mybatis.model.Emp;
import com.mybatis.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Brian in 15:35 2018/4/4
 */
public class DynamicSql {
    public static void main(String[] args) {
        SqlSessionFactory factory = DbUtil.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();

        EmployeeDynamicSql dynamicSql = sqlSession.getMapper(EmployeeDynamicSql.class);
        Emp emp = new Emp();
//        emp.setSal(BigDecimal.valueOf(800));
//        emp.setEmpno(Short.parseShort("7369"));
        emp.setJob("AN");

        List<Emp> list = null;
        List<Emp> emps = new ArrayList<>();
//        list = dynamicSql.getEmpIf(emp);
        list = dynamicSql.comsqlTest();


//        list = dynamicSql.getEmpChoose(emp);
        Short[] shorts = {7369, 7499, 7521};
//        list = dynamicSql.selectForeach(Arrays.asList(shorts));

        emps.add(new Emp(Short.parseShort("7903"), null, null, null, new Date(), null, null, new Dept(Short.parseShort("20")).getDeptno(), "F"));
        emps.add(new Emp(Short.parseShort("7904"), null, null, null, new Date(), null, null, new Dept(Short.parseShort("10")).getDeptno(), "M"));
        emps.add(new Emp(Short.parseShort("7905"), null, null, null, new Date(), null, null, new Dept(Short.parseShort("20")).getDeptno(), "F"));
        emps.add(new Emp(Short.parseShort("7906"), null, null, null, new Date(), null, null, new Dept(Short.parseShort("30")).getDeptno(), "F"));

//        dynamicSql.insertBatch(emps);
        System.out.println(list);

        sqlSession.commit();
        sqlSession.close();
    }
}
