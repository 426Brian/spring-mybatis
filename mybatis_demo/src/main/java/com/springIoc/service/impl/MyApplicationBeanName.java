package com.springIoc.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Brian in 18:15 2018/3/24
 */
public class MyApplicationBeanName implements ApplicationContextAware, BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
        System.out.println("MyApplicationBeanName == "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext =="+applicationContext.getBean(this.beanName));
    }
}
