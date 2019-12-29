package com.springIoc.service.impl;

import com.springIoc.service.InjectionDao;
import com.springIoc.service.InjectionService;

/**
 * Created by Brian in 15:44 2018/3/24
 */
public class InjectionServiceImpl implements InjectionService{

    private InjectionDao injectionDao;

    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    @Override
    public void save(String args) {
        System.out.println("== service接收参数 "+args);
        args = args+" = "+this.hashCode();

        injectionDao.save(args);
    }
}
