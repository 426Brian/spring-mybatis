package com.mybatis.model;

import java.util.Date;

/**
 * Created by Brian in 17:51 2018/3/13
 */
public class DemoUser {
    private String userName;
    private Integer userId;
    private Date inTime;


    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DemoUser{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", inTime=" + inTime +
                '}';
    }
}
