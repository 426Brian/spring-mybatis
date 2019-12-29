package com.mvc.test;


import com.mvcdemo.controller.CourseController;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by Brian in 21:27 2018/4/8
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/dispatcher.xml");

        System.out.println(context.getBean("helloController"));

        testObj("agaewgage");
        ArrayList<Integer> arr = new ArrayList();
        arr.add(2);
        arr.add(3);
        testObj(arr);
    }

    public static void testObj(Object obj){
        System.out.println(obj);
    }
}
