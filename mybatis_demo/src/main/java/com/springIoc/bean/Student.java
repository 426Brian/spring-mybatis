package com.springIoc.bean;

/**
 * Created by Brian in 16:14 2018/3/15
 */
public class Student {
    private String name;
    private int age;
    private int id;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
