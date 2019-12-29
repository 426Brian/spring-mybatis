package com.mybatis.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brian in 15:47 2018/11/12
 */
public class Test {
    public static void main(String[] args) {
        String str = "hello world, good morning";
        String[] arr = str.replace(",", " ,").split(" ");

        StringBuffer sbf = new StringBuffer();
        for (int i = arr.length-1; i >= 0; i--) {
            sbf.append(arr[i]+" ");
        }

        System.out.println(sbf.toString().replace(" ,", ","));
    }
}
