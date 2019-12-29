package com.springIoc.test;

import com.springIoc.service.OneInterface;
import com.springIoc.service.impl.OneImpl;

/**
 * Created by Brian in 16:56 2018/3/9
 */
public class Demo {
    public static void main(String[] args){
        OneInterface oif = new OneImpl();

        System.out.println(oif.sayHello("word"));

    }
}
