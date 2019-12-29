package com.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Brian in 22:21 2018/12/1
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/applicationContext.xml");

        Object obj = context.getBean("helloController");


        System.out.println("obj == "+obj.getClass().getName());
    }
}
