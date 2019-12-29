package com.jdbcTemplate.service;

/**
 * Created by Brian in 14:05 2018/4/10
 */
public interface AccountDao {
    void outMoney(String out, Double money);
    void inMoney(String in, Double money);
}
