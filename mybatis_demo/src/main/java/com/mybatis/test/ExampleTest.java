package com.mybatis.test;

import com.mybatis.dao.EmpMapper;
import com.mybatis.model.Emp;
import com.mybatis.model.EmpExample;
import com.mybatis.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Brian in 11:22 2018/4/7
 */
public class ExampleTest {
    /**
     * Mybatis 应用
     * 1. 根据xml配置文件（mybatis 的全局配置文件）
     *     有数据源的一些运行环境信息
     * 2. sql 映射文件，配置了每一个sql, 及其sql 的封装规则
     * 3. 将sql 映射文件注册在全局配置文件中
     * 4. 写代码
     *      1) 根据全局配置文件创建一个SqlSessionFactory 对象
     *      2) 使用工厂获取到sqlSession, 代表与数据库的一次会话, 用完后关闭
     *      3) 使用sql 唯一标识来执行sql
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取SqlSessionFactory
        SqlSessionFactory factory = DbUtil.getSqlSessionFactory();

        // 2. 获取SqlSession
        SqlSession session = factory.openSession();

        // 3. 获取接口的代理对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        System.out.println("empMapper == "+empMapper);

        // 查询所有
        List<Emp> emps = empMapper.selectByExample(null);

        // 查询员工名字中有e字母的，和员工性别是F
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andEnameLike("%N%");
        criteria.andGenderEqualTo("F");

        List<Emp> empList = empMapper.selectByExample(empExample);
        for (Emp emp : empList) {
            System.out.println(emp.toString());
        }

        session.commit();
        session.close();
    }
}
