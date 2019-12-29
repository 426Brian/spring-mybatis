package com.mybatis.noxml;

import com.mybatis.model.DemoUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不需要接口mapper, 只要有sql 映射文件注册在全局配置文件中即可
 * Created by Brian in 23:05 2018/11/10
 *
 */
public class Test {
    public static void main(String[] args) throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis/conf/mybatis_no.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DemoUser user = sqlSession.selectOne("getUserById", 3);
        System.out.println(user);
    }
}
