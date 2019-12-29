package com.jdbcTemplate.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Brian in 13:46 2018/4/10
 */
@Component
public class Test {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void jdbc(){
        System.out.println("jdbcTe == "+jdbcTemplate);
    }
}
