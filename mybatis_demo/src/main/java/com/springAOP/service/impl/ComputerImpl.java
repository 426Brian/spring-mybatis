package com.springAOP.service.impl;

import com.springAOP.service.Computer;

/**
 * Created by Brian in 16:22 2018/3/21
 */
public class ComputerImpl implements Computer {
    @Override
    public int add(int a, int b) {
        System.out.println("== 开始调用add方法，操作数为："+a+ "\t"+b);
        int result = a + b;
        System.out.println("== add方法结束，操作数为："+a+ "\t"+b);
        return a+b;

    }

    @Override
    public int sub(int a, int b) {
        System.out.println("== 开始调用sub方法，操作数为："+a+ "\t"+b);
        int result = a - b;
        System.out.println("== sub方法结束，操作数为："+a+ "\t"+b);
        return result;
    }

    @Override
    public int muti(int a, int b) {
        System.out.println("== 开始调用muti方法，操作数为："+a+ "\t"+b);
        int result = a * b;
        System.out.println("== muti方法结束，操作数为："+a+ "\t"+b);
        return result;
    }

    @Override
    public int dev(int a, int b) {
        System.out.println("== 开始调用dev方法，操作数为："+a+ "\t"+b);
        int result = a / b;
        System.out.println("== dev方法结束，操作数为："+a+ "\t"+b);
        return result;
    }
}
