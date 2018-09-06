package com.baidu.model;

import java.util.Date;

public class User {
    private Long id;

    private String username;

    private String password;

    private Integer age;

    private Date updateTime;

    public User() {
    }

    public User(String username, String password, Integer age, Date updateTime) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", updateTime=" + updateTime +
                '}';
    }
}
