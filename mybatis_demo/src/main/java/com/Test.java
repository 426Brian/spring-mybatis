package com;


/**
 * Created by Brian in 15:08 2018/3/31
 */
public class Test {
    private static int count;
    private String name;
    public Test(){
        count++;
    }
    public Test(String name){
        this.name = name;
        if("reset".equals(name)){
            count = 0;
        }
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.count);

        Test t2 = new Test();
        System.out.println(t2.count);

        Test t3 = new Test("reset");
        System.out.println(t3.count);

        System.exit(1);
        String str = "hello wolrd, good morning";
        String[] strs = str.split(" ");

        String str2 = "";
        int j = strs.length - 1;
        for(int i = j; i >= 0; i--){
            if(i != j){
                strs[i] = " "+strs[i];
            }
            if(strs[i].indexOf(",") > 0){
                strs[i] = ", "+strs[i].substring(1, strs[i].length() - 1);
            }
            str2 += strs[i];
        }

        System.out.println(str2);

    }
}