package com.jdbcTemplate.dataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Brian in 20:20 2018/3/28
 */

public class DbUtil {
    private JdbcTemplate jdbcTemplate;

    public DbUtil(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/applicationContext.xml");

        DbUtil db = new DbUtil((JdbcTemplate)ac.getBean("jdbcTemplate"));

       db.select();
    }

    public void select(){
        String sql = "select ename from emp where rownum = 1 order by empNo";
        ArrayList<String> list = (ArrayList<String>) jdbcTemplate.queryForList(sql, String.class);

        System.out.println(list);
    }
}
