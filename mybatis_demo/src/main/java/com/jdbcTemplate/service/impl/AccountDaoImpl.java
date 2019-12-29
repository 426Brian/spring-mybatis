package com.jdbcTemplate.service.impl;

import com.jdbcTemplate.service.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Brian in 14:07 2018/4/10
 */
//@Component("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        jdbcTemplate.update(sql, money, out);
        System.out.println("=== "+out+" 转出 "+ money);
    }

    @Override
    public void inMoney(String in, Double money){
        String sql = "update account set money = money + ? where name = ?";
        jdbcTemplate.update(sql, money, in);
        System.out.println("=== "+in+" 转入 "+ money);
    }
}
