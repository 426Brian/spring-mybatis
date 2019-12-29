package com.springAOP;

import com.springAOP.service.Computer;
import com.springAOP.service.impl.ComputerImpl2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Brian in 18:21 2018/3/28
 */
public class AspectDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"conf/spring/beans/bean.xml", "conf/spring/beans/aop.xml"});

        // computer 是基于注解的aop 配置文件 conf/spring/beans/bean.xml
        Computer computer = (Computer) ctx.getBean("computerImpl2");
        System.out.println(computer.getClass().getName());
        System.out.println(computer.add(2, 3));
        System.out.println(computer.dev(2, 1));

        // computer 是基于xml的aop 配置文件 conf/spring/beans/aop.xml
        Computer computer3 = (Computer) ctx.getBean("computer3");
        System.out.println(computer3.getClass().getName());
        computer3.muti(2, 5);
    }
}
