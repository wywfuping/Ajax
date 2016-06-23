package com.yawei.entity;


public class User {
    private Integer id;
    private String username;
    private String address;
    private Integer age;

    public User() {
    }

    public User(Integer id, String username, String address, Integer age) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
