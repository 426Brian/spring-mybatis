package com.jdbcTemplate.service;

/**
 * Created by Brian in 14:11 2018/4/10
 */
public interface AccountService {
    void transfer(String out, String in, Double money);

}
