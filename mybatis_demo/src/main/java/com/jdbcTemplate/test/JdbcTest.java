package com.jdbcTemplate.test;

import com.jdbcTemplate.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Brian in 14:58 2018/4/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:conf/spring/jdbcTemplate.xml")
public class JdbcTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("Jack", "Tom", (double) 200);
    }
}
