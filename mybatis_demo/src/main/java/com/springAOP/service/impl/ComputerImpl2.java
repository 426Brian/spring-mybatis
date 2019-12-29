package com.springAOP.service.impl;

import com.springAOP.service.Computer;
import org.springframework.stereotype.Component;

/**
 * Created by Brian in 16:22 2018/3/21
 */
@Component
public class ComputerImpl2 implements Computer {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    @Override
    public int muti(int a, int b) {
        int result = a * b;
        return result;
    }

    @Override
    public int dev(int a, int b) {
        int result = a / b;
        return result;
    }
}
