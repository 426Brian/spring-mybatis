package com.jdbcTemplate.dataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * Created by Brian in 20:15 2018/3/28
 */
public class DataSource {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) ac.getBean("dataSource");
        try {
            Connection conn = dataSource.getConnection();
            System.out.println(conn);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
