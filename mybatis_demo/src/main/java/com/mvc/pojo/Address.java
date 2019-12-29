package com.mvc.pojo;

/**
 * Created by Brian in 23:50 2018/4/6
 */
public class Address {
    private String city;
    private String street;

    public Address(){

    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void startAddress(){
        System.out.println("Address 创建时调用 === ");
    }
    public void endAddress(){
        System.out.println("Address 销毁时调用 === ");
    }


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
