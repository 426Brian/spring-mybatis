package com.study;

/**
 * Created by Brian in 16:42 2018/4/11
 */
public class Test {
    private int a;
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("before == "+t.a);
        int a = 3;

        Integer b = new Integer(3);
        System.out.println(a == b);

        change(a, t);
        System.out.println("after == "+t.a);
        System.out.println("a ==" +a);

    }

    public static void change(Integer b, Test te){
        b = 4;
        te.a = 5;

    }


}
