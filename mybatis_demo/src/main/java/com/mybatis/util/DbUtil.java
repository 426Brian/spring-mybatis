package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by Brian in 18:02 2018/4/2
 */
public class DbUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inStream;
    private static final String MYBATIS_XML = "conf/mybatis/conf/mybatis-conf.xml";
    static {

        try {
            inStream = Resources.getResourceAsStream(MYBATIS_XML);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;

    }

}
