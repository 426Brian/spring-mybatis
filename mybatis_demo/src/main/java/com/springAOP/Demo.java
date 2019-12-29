package com.springAOP;

import com.springAOP.service.Computer;
import com.springAOP.service.impl.ComputerImpl;
import com.springAOP.service.impl.ComputerImpl2;

/**
 * Created by Brian in 16:25 2018/3/21
 */
public class Demo {
    public static void main(String[] args) {
        Computer computerT = new ComputerImpl2();
        ComputerProxy computerProxy = new ComputerProxy(computerT);

        Computer computer = computerProxy.getComputerProxy();
        int result = computer.add(1, 2);
        System.out.println("result: "+result);


    }
}
