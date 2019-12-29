package com.mvc.pojo;

import java.util.Map;

/**
 * Created by Brian in 23:22 2018/4/6
 */
public class User {
    private Integer id;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
    private String name;
    private Address address;

    private Map<String, Integer> maps;

    public Map<String, Integer> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Integer> maps) {
        this.maps = maps;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(){

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", maps=" + maps +
                '}';
    }
}
