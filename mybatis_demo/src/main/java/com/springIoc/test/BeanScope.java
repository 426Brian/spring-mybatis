package com.springIoc.test;

/**
 * Created by Brian in 16:38 2018/3/24
 */
public class BeanScope {

    public void say(){
        System.out.println("beanscope say == "+this.hashCode());
    }
}
