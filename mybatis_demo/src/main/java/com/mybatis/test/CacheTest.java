package com.mybatis.test;

import com.mybatis.dao.EmployeeDynamicSql;
import com.mybatis.model.Emp;
import com.mybatis.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Brian in 20:36 2018/4/4
 */
public class CacheTest {
    public static void main(String[] args) {
        SqlSessionFactory factory = DbUtil.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
/*

        EmployeeDynamicSql empMapper = sqlSession.getMapper(EmployeeDynamicSql.class);
        EmployeeDynamicSql empMapper2 = sqlSession2.getMapper(EmployeeDynamicSql.class);

        Emp emp = new Emp();
        emp.setEmpno(Short.parseShort("7499"));

        Emp emp2 = new Emp();
        Emp emp3 = new Emp();
        emp2 = empMapper.empbyNo(emp);

        emp3 = empMapper.empbyNo(emp);

        emp.setEmpno(Short.parseShort("7521"));
        emp3 = empMapper2.empbyNo(emp);


        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        System.out.println(emp2 == emp3);
        System.out.println(emp2.equals(emp3));

        sqlSession.commit();
        sqlSession.close();

        sqlSession2.commit();
        sqlSession2.close();*/

        CacheTest cacheTest = new CacheTest();
        cacheTest.testSecondLevelCache(factory);
    }

    public void testSecondLevelCache(SqlSessionFactory factory){
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();

        EmployeeDynamicSql empMapper1  = session1.getMapper(EmployeeDynamicSql.class);
        EmployeeDynamicSql empMapper2  = session2.getMapper(EmployeeDynamicSql.class);

        Emp emp = new Emp();
        Emp emp1 = null;
        Emp emp2 = null;

        emp.setEmpno(Short.parseShort("7499"));

        emp1 = empMapper1.empbyNo(emp);
        System.out.println("emp1 == "+emp1);
        emp2 =empMapper1.empbyNo(emp);
        session1.close();

       /* emp2 =empMapper2.empbyNo(emp);
        System.out.println("emp2 == "+emp2);
        session2.close();*/
    }
}

































