package com.springIoc.service.impl;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by Brian in 18:08 2018/3/24
 */
public class MyBeanName implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        System.out.println("MyBeanName == "+name);
    }

    public String getBeanName() {
        return beanName;
    }
}
