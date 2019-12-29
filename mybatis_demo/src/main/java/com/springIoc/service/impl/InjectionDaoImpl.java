package com.springIoc.service.impl;

import com.springIoc.service.InjectionDao;

/**
 * Created by Brian in 15:36 2018/3/24
 */
public class InjectionDaoImpl implements InjectionDao {

    @Override
    public void save(String args) {
        System.out.println("== impl保存数据 "+args);
    }
}
