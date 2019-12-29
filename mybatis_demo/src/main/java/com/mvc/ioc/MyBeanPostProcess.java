package com.mvc.ioc;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * Created by Brian in 23:01 2018/4/8
 */
public class MyBeanPostProcess implements BeanPostProcessor{

    /**
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("正在进行初始化前的处理： 类名"+beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("正在进行初始化后的处理： 类名"+beanName);
        return null;
    }
}
