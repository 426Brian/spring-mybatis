package com.springIoc.test;

import com.springIoc.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Brian in 16:17 2018/3/15
 */
public class BeanDemo {
    public static void main(String[] args){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("springBean/beans.xml");

//        Student student1 = (Student) appContext.getBean("student1", Student.class);

        Student student3 = (Student) appContext.getBean("student3");
        System.out.println("name == "+student3.getName());

    }
}
