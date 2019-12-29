package com.mvc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Brian in 14:50 2018/4/6
 */
public class DBConnectionTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/spring/applicationContext.xml");
        DataSource datasource = (DataSource) context.getBean("datasource");


        try {
            Connection connection = datasource.getConnection("demo_01", "demo1814");
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
